package com.example.lab5.chat.lib

import android.os.Parcel
import android.os.Parcelable

public class CustomMessageProvider : IMessageProvider {
    private val _messages = mutableListOf<Message>();

    override suspend fun GetLastMessages(): List<Message> {
        return _messages;
    }

    override suspend fun AddMessage(message: Message) {
        _messages.add(0, message);
    }
}


public interface IMessageProvider {
    public suspend fun GetLastMessages() : List<Message>;
    public suspend fun AddMessage(message: Message);
}

public class Message(val Message: String, val Host: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Message)
        parcel.writeString(Host)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Message> {
        override fun createFromParcel(parcel: Parcel): Message {
            return Message(parcel)
        }

        override fun newArray(size: Int): Array<Message?> {
            return arrayOfNulls(size)
        }
    }
};