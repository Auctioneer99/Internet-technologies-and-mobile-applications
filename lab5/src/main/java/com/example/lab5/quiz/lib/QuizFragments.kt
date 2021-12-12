package com.example.lab5.quiz.lib

import androidx.fragment.app.Fragment
import com.example.lab5.common.*

abstract class AQuizStartFragment() : Fragment() {
    public val Start : Event<Unit> = Event();
}

abstract class AQuizFinalFragment(): Fragment() {
    public lateinit var Result: Result
}

abstract class AQuizQuestionFragment(public val Question: Question) : Fragment() {
    public val Chosen : Event<OptionSelectedArg> = Event();
}

class OptionSelectedArg(val View: AQuizQuestionFragment, val OptionId: Int);

