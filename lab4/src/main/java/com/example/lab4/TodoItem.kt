package com.example.lab4

import android.os.Parcel
import android.os.Parcelable


class TodoItem() : Parcelable {
    companion object {
        const val HEADER_LENGTH: Int = 15;
        const val BODY_LENGTH: Int = 70;
        @JvmField
        val CREATOR = object : Parcelable.Creator<TodoItem> {
            override fun createFromParcel(parcel: Parcel): TodoItem {
                return TodoItem(parcel)
            }

            override fun newArray(size: Int): Array<TodoItem?> {
                return arrayOfNulls(size)
            };
        }
    }

    public lateinit var Header: String
    public lateinit var Body: String

    public val HeaderShortcut: String
        get() = Shortcut(Header, HEADER_LENGTH);

    public val BodyShortcut: String
        get() = Shortcut(Body, BODY_LENGTH);

    constructor(parcel: Parcel) : this() {
        Header = parcel.readString()?: ""
        Body = parcel.readString()?: ""
    }

    constructor(header: String, body: String) : this() {
        Body = body
        Header = header
    }

    private fun Shortcut(value: String, length: Int): String
    {
        var result: String;
        if (value.length > length)
        {
            result = value.slice(IntRange(0, length));
            result += "...";
        }
        else
        {
            result = value;
        }
        return result;
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Header)
        parcel.writeString(Body)
    }

    override fun describeContents(): Int {
        return 0
    }
}