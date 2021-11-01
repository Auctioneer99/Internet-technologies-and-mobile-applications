package com.example.lab5.quiz

import com.example.lab5.quiz.lib.Option
import com.example.lab5.quiz.lib.Question
import com.example.lab5.quiz.lib.QuizFragmentHandler
import com.example.lab5.quiz.lib.QuizViewBuilder

class QuizFactory
{
    public fun BuildFoxQuiz(): QuizFragmentHandler
    {
        //Fox api

        val description = "It is a fox quiz";

        //

        val builder = QuizViewBuilder();
        builder
            .SetFinalPage(FinalPage())
            .SetInitialPage(InitialPage(description));
        //Fox api

        val questions = listOf(Question(1, "Что это", listOf(Option(1, "Это"), Option(2, "Или это"))));

        for(question in questions)
        {
            builder.AddNextView(ChooseAnswerQuestion(question));
        }

        //
        return builder.Build();
    }
}