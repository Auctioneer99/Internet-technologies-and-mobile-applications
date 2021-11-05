package com.example.lab5.chat

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5.R
import com.example.lab5.chat.lib.Message
import kotlinx.android.synthetic.main.activity_chat_add_message.*

class ChatAddMessageActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_add_message);

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(::OnBackClick);
        send_message.setOnClickListener(::AddMessage)
    }

    private fun OnBackClick(view: View)
    {
        onBackPressed();
    }

    private fun AddMessage(view: View)
    {
        val intent = Intent();
        val message = Message(name.text.toString(), message.text.toString());
        intent.putExtra("message", message);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed();
        return true;
    }
}