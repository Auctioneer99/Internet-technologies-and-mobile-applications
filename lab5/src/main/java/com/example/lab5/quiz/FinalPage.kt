package com.example.lab5.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5.R
import com.example.lab5.quiz.lib.AQuizFinalFragment
import com.example.lab5.quiz.lib.Result
import kotlinx.android.synthetic.main.quiz_finalpage.*


class FinalPage() : AQuizFinalFragment() {
    override fun SetResult(result: Result) {
        this.result.text = result.Score.toString();
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val inf = inflater.inflate(R.layout.quiz_finalpage, container, false);
        (activity as AppCompatActivity).setSupportActionBar(toolbar);

        return inf;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}