package com.example.lab5.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5.R
import com.example.lab5.quiz.lib.AQuizQuestionFragment
import com.example.lab5.quiz.lib.OptionSelectedArg
import com.example.lab5.quiz.lib.Question
import kotlinx.android.synthetic.main.quiz_choose_question.*
import kotlinx.android.synthetic.main.quiz_choose_question.view.*

class ChooseAnswerQuestion(question: Question): AQuizQuestionFragment(question) {

    private val _answers = mutableListOf<Answer>();
    private var _selectedAnswer: Answer? = null;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val inf = inflater.inflate(R.layout.quiz_choose_question, container, false);
        SetView(inf);
        return inf;
    }

    private fun SetView(inf: View)
    {
        inf.question_number.text = "Вопрос " + _question.Id;
        inf.question_description.text = _question.Name;
        val fragmentManager = childFragmentManager;
        val ids = listOf(R.id.message, R.id.answer_2, R.id.answer_3, R.id.answer_4);
        for((i, id) in ids.withIndex()) {
            val chooseAnswerView = ChooseAnswerView(_question.Options[i]);
            fragmentManager.beginTransaction().replace(id, chooseAnswerView, chooseAnswerView.javaClass.getSimpleName()).commit();
            chooseAnswerView.Clicked.plusAssign(::OnAnswerChosen);
            _answers.add(chooseAnswerView);
        }
        inf.choose_button.setOnClickListener(::OnClickHandle)
    }

    private fun OnAnswerChosen(answer: Answer)
    {
        if (_selectedAnswer != answer) {
            _selectedAnswer?.SetState(AnswerState.Default);
            answer.SetState(AnswerState.Selected);
            _selectedAnswer = answer;
        }
        choose_button.isEnabled = true;
    }

    private fun OnClickHandle(view: View?)
    {
        Chosen.invoke(OptionSelectedArg(this, _selectedAnswer?.Option?.Id ?: 0));
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}