package com.example.lab5.views

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.lab5.R
import com.example.lab5.quiz.Answer
import com.example.lab5.quiz.AnswerState
import kotlinx.android.synthetic.main.view_quiz_choose_answer.view.*

class ChooseQuestionView(context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs), Answer {

    public override var AnswerId: Int = 0;

    public override var State = AnswerState.Default
        set(state) {
            field = state;
            when (state) {
                AnswerState.Default -> {

                    your_choice.visibility = View.INVISIBLE;
                    outer_frame.setCardBackgroundColor(Color.YELLOW)
                }
                AnswerState.Selected -> {
                    your_choice.visibility = View.VISIBLE;
                    outer_frame.setCardBackgroundColor(Color.rgb(76, 175, 80));
                }
                AnswerState.Wrong -> {

                }
            }
            invalidate()
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_quiz_choose_answer, this, true)

        setupAttributes(attrs);
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.ChooseQuestionView,
            0, 0)

        State = AnswerState.getByValue((typedArray.getInt(R.styleable.ChooseQuestionView_state, 0))) ?: AnswerState.Default;
        AnswerId = typedArray.getInteger(R.styleable.ChooseQuestionView_answer_id, 0);
        message.text = typedArray.getString(R.styleable.ChooseQuestionView_message);
        typedArray.recycle()
    }
}