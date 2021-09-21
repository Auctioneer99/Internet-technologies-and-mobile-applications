package com.example.lab3

class Value {
    public var Initialized: Boolean = false
        private set;

    public val Number: Double
        get() = RawNumber.toDoubleOrNull()?: 0.0;

    public val RawNumber: String
        get() = (if (_negate) "-" else "") + _stringNumber;

    private var _hasDot: Boolean = false;
    private var _stringNumber: String = "";
    private var _negate: Boolean = false;

    public fun SetValue(number: Double)
    {
        Reset();
        Initialized = true;
        if (number < 0)
        {
            _negate = true;
            _stringNumber = (number * -1).toString();
        }
        else
        {
            _negate = false;
            _stringNumber = number.toString();
        }
        var rest = number % 1;
        if (rest > 0 && rest < 1)
        {
            _hasDot = true;
        }
    }

    public fun AddDigit(value: Int)
    {
        _stringNumber += value;
        Initialized = true;
    }

    public fun AddDot()
    {
        if (_hasDot)
        {
            return;
        }
        if (Initialized == false)
        {
            _stringNumber += "0";
        }
        _stringNumber += ".";
        Initialized = true;
        _hasDot = true;
    }

    public fun Negate()
    {
        _negate = !_negate;
    }

    public fun Reset()
    {
        _hasDot = false;
        Initialized = false;
        _stringNumber = "";
        _negate = false;
    }
}