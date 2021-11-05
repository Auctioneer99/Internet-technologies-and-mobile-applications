package com.example.lab5.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.lab5.R
import kotlinx.android.synthetic.main.view_chat_message.view.*

class ChatMessageView(context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs) {
    init {
        LayoutInflater.from(context).inflate(R.layout.view_chat_message, this, true)

        setupAttributes(attrs);
    }

    private fun setupAttributes(attrs: AttributeSet?) {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.ChooseQuestionView,
            0, 0)
        message_text.text = typedArray.getString(R.styleable.ChatMessageView_message);
        message_host.text = typedArray.getString(R.styleable.ChatMessageView_host);
        typedArray.recycle()
    }

}