package com.example.lab5.quiz.lib

class Question(val Id: Int, val Name: String, val Options: List<Option>)
class Option(val Id: Int, val Message: String);

class Result(val Score: Int);