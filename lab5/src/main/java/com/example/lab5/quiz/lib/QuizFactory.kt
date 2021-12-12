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

        var answerMap = mutableMapOf<Int, Int>(
            Pair(1, 1),
            Pair(2, 1),
            Pair(3, 1),
            Pair(4, 1),
            Pair(5, 1)
        )

        builder.SetChecker(CustomAnswerChecker(answerMap));

        val questions = listOf(
            Question(1, "Что это", listOf(
                Option(1, "Это"),
                Option(2, "Или это"),
                Option(3, "Или это"),
                Option(4, "Или это"))),
            Question(2, "Что это", listOf(
                Option(1, "Это"),
                Option(2, "Или это"),
                Option(3, "Или это"),
                Option(4, "Или это"))),
            Question(3, "Что это", listOf(
                Option(1, "Это"),
                Option(2, "Или это"),
                Option(3, "Или это"),
                Option(4, "Или это"))),
            Question(4, "Что это", listOf(
                Option(1, "Это"),
                Option(2, "Или это"),
                Option(3, "Или это"),
                Option(4, "Или это"))),
            Question(5, "Что это", listOf(
                Option(1, "Это"),
                Option(2, "Или это"),
                Option(3, "Или это"),
                Option(4, "Или это")))
            );

        for(question in questions)
        {
            builder.AddNextView(ChooseAnswerQuestionPage(question));
        }

        //
        return builder.Build();
    }
}