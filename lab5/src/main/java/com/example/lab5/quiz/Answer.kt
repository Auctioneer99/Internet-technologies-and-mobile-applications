package com.example.lab5.quiz

interface Answer
{
    val AnswerId: Int;
    var State: AnswerState;
}

enum class AnswerState(val value: Int)
{
    Default(0),
    Selected(1),
    Wrong(2);

    companion object {
        private val VALUES = values()
        fun getByValue(value: Int) = VALUES.firstOrNull { it.value == value }
    }
}