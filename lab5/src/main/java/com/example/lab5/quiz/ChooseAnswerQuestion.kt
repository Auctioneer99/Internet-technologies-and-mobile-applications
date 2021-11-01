package com.example.lab5.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5.R
import com.example.lab5.quiz.lib.AQuizQuestionFragment
import com.example.lab5.quiz.lib.Question
import kotlinx.android.synthetic.main.quiz_choose_question.*

class ChooseAnswerQuestion: AQuizQuestionFragment {

    constructor(question: Question) : super(question)
    {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val inf = inflater.inflate(R.layout.quiz_choose_question, container, false);
        (activity as AppCompatActivity).setSupportActionBar(toolbar);

        return inf;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}