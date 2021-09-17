package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var _equation : QuadraticEquation;

    private lateinit var _inputA : TextView;
    private lateinit var _inputB : TextView;
    private lateinit var _inputC : TextView;
    private lateinit var _outputText : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _equation = QuadraticEquation();
        _outputText = findViewById(R.id.outputText);
        _inputA = findViewById(R.id.inputA);
        _inputB = findViewById(R.id.inputB);
        _inputC = findViewById(R.id.inputC);
    }

    public fun onCalculateHandler(view: View?)
    {
        _equation.A = GetDouble(_inputA);
        _equation.B = GetDouble(_inputB);
        _equation.C = GetDouble(_inputC);

        val result = _equation.Calculate();
        _outputText.text = "X1: " + result.X1 + ", X2: " + result.X2;
    }

    private fun GetDouble(view: TextView) : Double
    {
        return view.text.toString().toDoubleOrNull()?: 0.0;
    }
}