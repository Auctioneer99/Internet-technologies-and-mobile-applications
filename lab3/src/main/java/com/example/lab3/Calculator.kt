package com.example.lab3

class Calculator
{
    public var FirstValue: Value = Value()
        private set;
    public var SecondValue: Value = Value()
        private set;
    public var Operation: MathOperation = MathOperation.NONE
        private set;

    private var _shouldAppendFirstValue: Boolean = false;

    public fun Calculate()
    {
        var first: Double = FirstValue.Number;
        var second: Double = SecondValue.Number;
        when (Operation) {
            MathOperation.PLUS -> first += second;
            MathOperation.MINUS -> first -= second;
            MathOperation.MULTIPLICATION -> first *= second;
            MathOperation.DIVISION -> first /= second;
        }
        Reset();
        if (first.isFinite() == false)
        {
            first = 0.0;
        }
        FirstValue.SetValue(first);
        _shouldAppendFirstValue = false;
    }

    public fun SelectOperator(operation: MathOperation)
    {
        if (SecondValue.Initialized)
        {
            Calculate();
        }
        if (FirstValue.Initialized)
        {
            Operation = operation;
        }
    }

    public fun AddDigit(value: Int)
    {
        HandleFirstValue();
        SelectValue().AddDigit(value);
    }

    public fun AddDot()
    {
        HandleFirstValue();
        SelectValue().AddDot();
    }

    public fun Negate()
    {
        HandleFirstValue();
        SelectValue().Negate();
    }

    private fun SelectValue(): Value
    {
        if (Operation == MathOperation.NONE)
        {
            return FirstValue;
        }
        else
        {
            return SecondValue;
        }
    }

    private fun HandleFirstValue()
    {
        if (Operation == MathOperation.NONE)
        {
            if (_shouldAppendFirstValue == false)
            {
                FirstValue.Reset();
                _shouldAppendFirstValue = true;
            }
        }
    }

    public fun Reset()
    {
        Operation = MathOperation.NONE;
        FirstValue.Reset();
        SecondValue.Reset();
        _shouldAppendFirstValue = true;
    }
}