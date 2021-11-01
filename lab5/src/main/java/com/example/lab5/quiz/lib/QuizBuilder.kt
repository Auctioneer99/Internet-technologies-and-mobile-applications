package com.example.lab5.quiz.lib

class QuizViewBuilder
{
    private lateinit var _initialPage: AQuizStartFragment;
    private lateinit var _finalPage: AQuizFinalFragment;
    private val _questions: MutableList<AQuizQuestionFragment> = mutableListOf();

    public fun SetInitialPage(fragment: AQuizStartFragment): QuizViewBuilder
    {
        _initialPage = fragment;
        return this;
    }

    public fun SetFinalPage(fragment: AQuizFinalFragment): QuizViewBuilder
    {
        _finalPage = fragment;
        return this;
    }

    public fun AddNextView(fragment: AQuizQuestionFragment): QuizViewBuilder
    {
        _questions.add(0, fragment);
        return this;
    }

    public fun Build() : QuizFragmentHandler
    {
        val pages = LinkPages();
        val qHandler = QuizFragmentHandler(
            _initialPage,
            _finalPage,
            pages
        );
        qHandler.Initialize();
        return qHandler;
    }

    private fun LinkPages() : LinkedFragment?
    {
        var link: LinkedFragment? = null;
        for (question in _questions)
        {
            val temp = LinkedFragment(question, link);
            link = temp;
        }
        return link;
    }
}