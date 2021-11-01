package com.example.lab5.common

class Event<T> {
    private val observers = mutableSetOf<(T) -> Unit>()

    operator fun plusAssign(observer: (T) -> Unit) {
        observers.add(observer)
    }

    operator fun minusAssign(observer: (T) -> Unit) {
        observers.remove(observer)
    }

    operator fun invoke(value: T) {
        for (observer in observers)
            observer(value)
    }
}
/*
class Event<T1, T2> {
    private val observers = mutableSetOf<(T1, T2) -> Unit>()

    operator fun plusAssign(observer: (T1, T2) -> Unit) {
        observers.add(observer)
    }

    operator fun minusAssign(observer: (T1, T2) -> Unit) {
        observers.remove(observer)
    }

    operator fun invoke(value1: T1, value2: T2) {
        for (observer in observers)
            observer(value1, value2);
    }
}*/