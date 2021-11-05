package com.example.lab5.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5.R
import com.example.lab5.quiz.lib.AQuizFinalFragment
import com.example.lab5.quiz.lib.Result
import kotlinx.android.synthetic.main.page_quiz_final.*
import kotlinx.android.synthetic.main.page_quiz_final.toolbar


class FinalPage() : AQuizFinalFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
        = inflater.inflate(R.layout.page_quiz_final, container, false);

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(toolbar);

        result.text = Result.Score.toString();
    }
}