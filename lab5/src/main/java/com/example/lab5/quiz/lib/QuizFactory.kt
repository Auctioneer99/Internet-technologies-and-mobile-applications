package com.example.lab5.quiz.lib

import com.example.lab5.quiz.ChooseAnswerQuestionPage
import com.example.lab5.quiz.FinalPage
import com.example.lab5.quiz.InitialPage

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

        val questions = listOf(Question(1, "Что это", listOf(Option(1, "Это"), Option(2, "Или это"), Option(3, "Или это"), Option(4, "Или это"))));

        for(question in questions)
        {
            builder.AddNextView(ChooseAnswerQuestionPage(question));
        }

        //
        return builder.Build();
    }
}