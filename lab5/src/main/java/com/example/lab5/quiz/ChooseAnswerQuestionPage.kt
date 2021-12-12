package com.example.lab5.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lab5.R
import com.example.lab5.quiz.lib.AQuizQuestionFragment
import com.example.lab5.quiz.lib.OptionSelectedArg
import com.example.lab5.quiz.lib.Question
import kotlinx.android.synthetic.main.page_quiz_choose_question.*
import kotlinx.android.synthetic.main.view_quiz_choose_answer.view.*

class ChooseAnswerQuestionPage(question: Question): AQuizQuestionFragment(question) {

    private var _selectedAnswer: Answer? = null;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
        = inflater.inflate(R.layout.page_quiz_choose_question, container, false);

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        question_number.text = "Вопрос " + Question.Id;
        question_description.text = Question.Name;
        val ids = listOf(answer_1, answer_2, answer_3, answer_4);
        for((i, answer) in ids.withIndex()) {
            answer.AnswerId = Question.Options[i].Id;
            answer.message.text = Question.Options[i].Message;
            answer.setOnClickListener { _ -> OnAnswerChosen(answer) };
        }
        choose_button.setOnClickListener(::OnClickHandle)
    }

    private fun OnAnswerChosen(answer: Answer)
    {
        if (_selectedAnswer != answer) {
            _selectedAnswer?.State = AnswerState.Default;
            answer.State = AnswerState.Selected;
            _selectedAnswer = answer;
        }
        choose_button.isEnabled = true;
    }

    private fun OnClickHandle(view: View?)
    {
        Chosen.invoke(OptionSelectedArg(this, _selectedAnswer?.AnswerId ?: 0));
    }
}