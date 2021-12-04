package com.example.lab5

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.lab5.chat.lib.AppDatabase
import com.example.lab5.chat.lib.IMessageProvider
import com.example.lab5.chat.lib.RoomMessageProvider
import kotlinx.android.synthetic.main.activity_main.*
import com.example.lab5.quiz.lib.*

class MainActivity : AppCompatActivity() {

    private val _quizFragmentHandler: QuizFragmentHandler by lazy {
        var handler = _quizFactory.BuildFoxQuiz();
        handler.ViewChanged.plusAssign(::SetFragmentView);
        handler;
    }

    private val _quizFactory: QuizFactory = QuizFactory();

    private lateinit var _dataBase: AppDatabase;
    private lateinit var _messageProvider: IMessageProvider;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(::OnNavigationItemSelected)
        _dataBase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build();
        val dao = _dataBase.MessageDao();
        _messageProvider = RoomMessageProvider(dao);
        SetFragmentView(ChatFragment(_messageProvider));
    }

    private fun OnNavigationItemSelected(item: MenuItem): Boolean
    {
        return when(item.itemId) {
            R.id.page_chat -> {
                SetFragmentView(ChatFragment(_messageProvider));
                true
            }
            R.id.page_quiz -> {
                SetFragmentView(_quizFragmentHandler.View);
                true
            }
            else -> false
        }
    }

    private fun SetFragmentView(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
            .commit()
    }
}