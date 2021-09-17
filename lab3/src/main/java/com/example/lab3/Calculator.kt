package com.example.lab3

class Calculator
{
    public var Value : Double = 0.0;
    public val Current: String
        get() = (if (_isNegate) "-" else "") + _current;
    public val Operation: MathOperation
        get() = _operation;

    private var _current : String = "";
    private var _hasInitialValue : Boolean = false;
    private var _operation : MathOperation = MathOperation.NONE;
    private var _isNegate : Boolean = false;

    public fun Calculate()
    {
        var a = _current.toDoubleOrNull()?: 0.0;
        if (_isNegate)
        {
            a *= -1;
        }
        when (_operation) {
            MathOperation.PLUS -> Value += a;
            MathOperation.MINUS -> Value -= a;
            MathOperation.MULTIPLICATION -> Value *= a;
            MathOperation.DIVISION -> Value /= a;
        }
        ClearNextOperation();
    }

    public fun SelectOperator(operation: MathOperation)
    {
        if (_hasInitialValue)
        {
            Calculate();
        }
        _operation = operation;
    }

    public fun AddDigit(value: Int)
    {
        if (_operation == MathOperation.NONE)
        {
            return;
        }
        _current += value;
        _hasInitialValue = true;
    }

    public fun AddDot()
    {
        if (_operation == MathOperation.NONE)
        {
            return;
        }
        if (_hasInitialValue == false)
        {
            _current += "0";
        }
        _current += ".";
        _hasInitialValue = true;
    }

    public fun Negate()
    {
        if (_operation == MathOperation.NONE)
        {
            return;
        }
        _isNegate = !_isNegate;
    }

    public fun Ac()
    {
        Value = 0.0;
        ClearNextOperation();
    }

    private fun ClearNextOperation()
    {
        _current = "";
        _hasInitialValue = false;
        _operation = MathOperation.NONE;
        _isNegate = false;
    }
}

enum class MathOperation(val operation: Byte) {
    NONE(0),
    PLUS(1),
    MINUS(2),
    MULTIPLICATION(3),
    DIVISION(4)
}