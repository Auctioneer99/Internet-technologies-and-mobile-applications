package com.example.lab5.quiz.lib

import androidx.fragment.app.Fragment
import com.example.lab5.common.*

abstract class AQuizStartFragment() : Fragment() {
    public val Start : Event<Unit> = Event();
}

abstract class AQuizFinalFragment(): Fragment() {
    public abstract fun SetResult(result: Result);
}

abstract class AQuizQuestionFragment(protected val _question: Question) : Fragment() {
    public val Chosen : Event<OptionSelectedArg> = Event();
}

class OptionSelectedArg(val Question: AQuizQuestionFragment, val OptionId: Int);

