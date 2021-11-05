package com.example.lab5.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5.R
import com.example.lab5.quiz.lib.AQuizStartFragment
import kotlinx.android.synthetic.main.page_quiz_initial.*
import kotlinx.android.synthetic.main.page_quiz_initial.toolbar

class InitialPage(private val _description: String) : AQuizStartFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
        = inflater.inflate(R.layout.page_quiz_initial, container, false);

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(toolbar);
        text_description.text = _description;
        button_start.setOnClickListener { _ -> Start.invoke(Unit)}
    }
}