package com.example.lab5.quiz.lib

import androidx.fragment.app.Fragment
import com.example.lab5.common.*
import com.example.lab5.quiz.ChooseAnswerQuestionPage

class QuizFragmentHandler(initialView : AQuizStartFragment, finalView : AQuizFinalFragment, firstLinkedFragment: LinkedFragment?, private val _answerChecker : IAnswerChecker) {
    public val ViewChanged: Event<Fragment> = Event();

    public var View: Fragment
        get() {
            return _view;
        }
        private set(value) {
        _view = value;
        ViewChanged.invoke(_view);
    }
    private var _view: Fragment = initialView;

    private val _initial: AQuizStartFragment = initialView;
    private val _final: AQuizFinalFragment = finalView;
    private var _question: LinkedFragment? = firstLinkedFragment;
    private val _responseMap: MutableMap<Int, Int> = mutableMapOf();


    public fun Initialize()
    {
        _initial.Start.plusAssign(::QuizStarted);
    }

    private fun QuizStarted(junk: Unit)
    {
        _initial.Start.minusAssign(::QuizStarted);

        SetFragment(_question);
    }

    private fun OptionChosen(arg: OptionSelectedArg)
    {
        arg.View.Chosen.minusAssign(::OptionChosen);
        _responseMap.put(arg.View.Question.Id, arg.OptionId);

        SetFragment(_question?.Next);
    }

    private fun SetFragment(fragment: LinkedFragment?)
    {
        if (fragment != null) {
            _question = fragment;
            fragment.View.Chosen.plusAssign(::OptionChosen);
            View = fragment.View;
        }
        else
        {
            SetResult();
        }
    }

    private fun SetResult()
    {
        var count = 0;
        for(answer in _responseMap)
        {
            if (_answerChecker.Check(answer.key, answer.value))
            {
                count++;
            }
        }
        _final.Result = Result(count);
        View = _final;
    }
}

class LinkedFragment(val View : AQuizQuestionFragment, val Next : LinkedFragment?)

