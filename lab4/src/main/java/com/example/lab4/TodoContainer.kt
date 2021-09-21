package com.example.lab4

class TodoContainer {
    public val Changed: Event<Int> = Event<Int>()

    public val Count: Int
        get() = _items.size;

    private val _items: ArrayList<TodoItem> = arrayListOf();

    public fun Get(index: Int): TodoItem
    {
        return _items[index];
    }

    public fun Add(newItem: TodoItem)
    {
        _items.add(newItem);
        Changed.invoke(1);
    }

    public fun Remove(index: Int)
    {
        if (index <= -1)
        {
            return;
        }
        _items.removeAt(index);
        Changed.invoke(1);
    }
}