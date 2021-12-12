package com.example.lab5.quiz.lib

interface IAnswerChecker {
    fun Check(answerId: Int, optionId: Int) : Boolean;
}

public class CustomAnswerChecker(private val _answers: MutableMap<Int, Int>): IAnswerChecker
{
    override fun Check(answerId: Int, optionId: Int): Boolean {
        return (_answers[answerId] == optionId);
    }
}