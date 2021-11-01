package com.example.lab5.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5.R
import com.example.lab5.quiz.lib.AQuizStartFragment
import kotlinx.android.synthetic.main.quiz_initialpage.*
import kotlinx.android.synthetic.main.quiz_initialpage.view.*

class InitialPage(private val _description: String) : AQuizStartFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val inf = inflater.inflate(R.layout.quiz_initialpage, container, false);
        (activity as AppCompatActivity).setSupportActionBar(toolbar);
        inf.text_description.text = _description;
        inf.button_start.setOnClickListener { _ -> Start.invoke(Unit)}
        return inf;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}