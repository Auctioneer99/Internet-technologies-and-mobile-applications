package com.example.lab5.quiz

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab5.R
import com.example.lab5.common.Event
import com.example.lab5.quiz.lib.Option
import kotlinx.android.synthetic.main.choose_answer_view.*
import kotlinx.android.synthetic.main.choose_answer_view.view.*

class ChooseAnswerView : Fragment, Answer {
    private lateinit var _view: View;
    public override val Option: Option;
    public override val Clicked: Event<Answer>;

    constructor(option: Option) : super()
    {
        Option = option;
        Clicked = Event();
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        _view = inflater.inflate(R.layout.choose_answer_view, container, false);
        _view.message.text = Option.Message;
        _view.outer_frame.setOnClickListener(::OnClick);
        return _view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun SetState(state: AnswerState) {
        when (state) {
            AnswerState.Default -> {
                _view.your_choice.visibility = View.INVISIBLE;
                _view.outer_frame.setCardBackgroundColor(Color.WHITE)
            }
            AnswerState.Selected -> {
                _view.your_choice.visibility = View.VISIBLE;
                _view.outer_frame.setCardBackgroundColor(Color.rgb(76, 175, 80));
            }
            AnswerState.Wrong -> {

            }
        }
    }

    private fun OnClick(view: View?)
    {
        Clicked.invoke(this);
    }
}

interface Answer
{
    val Option: Option;
    val Clicked: Event<Answer>;
    fun SetState(state: AnswerState)
}

enum class AnswerState(value: Byte)
{
    Default(0),
    Selected(1),
    Wrong(2)
}