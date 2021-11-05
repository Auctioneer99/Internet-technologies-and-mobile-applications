package com.example.lab5.chat.lib

import android.util.Log
import androidx.room.*

class RoomMessageProvider(private val _dao: MessageDAO): IMessageProvider {
    override suspend fun GetLastMessages(): List<Message> {
        return _dao.GetLastMessages().map{ Message(it.roomText, it.roomHost) }
    }

    override suspend fun AddMessage(message: Message) {
        _dao.AddMessage(RoomMessage(message.Host, message.Message));
        Log.d("Add", "added");
    }
}

@Database(entities = [RoomMessage::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun MessageDao(): MessageDAO
}

@Dao
interface MessageDAO {
    @Query("SELECT * FROM roommessage")
    fun GetLastMessages(): List<RoomMessage>

    @Insert
    fun AddMessage(vararg messages: RoomMessage);
}

@Entity
data class RoomMessage(
    @ColumnInfo(name = "host") val roomHost: String,
    @ColumnInfo(name = "text") val roomText: String
) {
    @PrimaryKey(autoGenerate = true) var uid: Int = 0
}