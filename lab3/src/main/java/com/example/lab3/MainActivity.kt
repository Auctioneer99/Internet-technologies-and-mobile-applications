package com.example.lab3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val _calculator : Calculator = Calculator();
    private lateinit var _text : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.digit0).setOnClickListener({ _ -> AddDigit(0) });
        findViewById<Button>(R.id.digit1).setOnClickListener({ _ -> AddDigit(1) });
        findViewById<Button>(R.id.digit2).setOnClickListener({ _ -> AddDigit(2) });
        findViewById<Button>(R.id.digit3).setOnClickListener({ _ -> AddDigit(3) });
        findViewById<Button>(R.id.digit4).setOnClickListener({ _ -> AddDigit(4) });
        findViewById<Button>(R.id.digit5).setOnClickListener({ _ -> AddDigit(5) });
        findViewById<Button>(R.id.digit6).setOnClickListener({ _ -> AddDigit(6) });
        findViewById<Button>(R.id.digit7).setOnClickListener({ _ -> AddDigit(7) });
        findViewById<Button>(R.id.digit8).setOnClickListener({ _ -> AddDigit(8) });
        findViewById<Button>(R.id.digit9).setOnClickListener({ _ -> AddDigit(9) });

        findViewById<Button>(R.id.operator1).setOnClickListener({ _ -> SetOperator(MathOperation.DIVISION) });
        findViewById<Button>(R.id.operator2).setOnClickListener({ _ -> SetOperator(MathOperation.MULTIPLICATION) });
        findViewById<Button>(R.id.operator3).setOnClickListener({ _ -> SetOperator(MathOperation.MINUS) });
        findViewById<Button>(R.id.operator4).setOnClickListener({ _ -> SetOperator(MathOperation.PLUS) });

        _text = findViewById<Button>(R.id.text);

        UpdateValue();
    }

    public fun Calculate(view: View)
    {
        _calculator.Calculate();
        UpdateValue();
    }

    public fun SetOperator(operator: MathOperation)
    {
        _calculator.SelectOperator(operator);
        UpdateValue();
    }

    public fun AddDigit(digit: Int)
    {
        _calculator.AddDigit(digit);
        UpdateValue();
    }

    public fun AddDot(view: View)
    {
        _calculator.AddDot();
        UpdateValue();
    }

    public fun Negate(view: View)
    {
        _calculator.Negate();
        UpdateValue();
    }

    private fun UpdateValue()
    {
        _text.text = _calculator.Value.toString() + " " + _calculator.Operation + " " + _calculator.Current;
    }
}