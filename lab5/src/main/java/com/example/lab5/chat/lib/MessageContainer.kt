package com.example.lab5.chat.lib

import com.example.lab5.common.Event

class MessageContainer {
    public val Changed: Event<Unit> = Event()

    public val Count: Int
        get() = _items.size;


    private val _items: ArrayList<Message> = arrayListOf();

    public fun Get(index: Int): Message
    {
        return _items[index];
    }

    public fun Add(newItem: Message)
    {
        _items.add(newItem);
        Changed.invoke(Unit);
    }

    public fun Clear()
    {
        _items.clear();
        Changed.invoke(Unit);
    }

    public fun Remove(index: Int)
    {
        if (index <= -1)
        {
            return;
        }
        _items.removeAt(index);
        Changed.invoke(Unit);
    }
}