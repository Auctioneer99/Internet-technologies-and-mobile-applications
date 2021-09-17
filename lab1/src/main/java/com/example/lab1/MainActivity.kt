package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var _text: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _text = findViewById(R.id.text);
    }

    public fun onClickHandler(view: View?) {
        Toast.makeText(this, _text.text, Toast.LENGTH_SHORT).show()
    }
}