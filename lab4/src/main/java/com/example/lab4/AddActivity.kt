package com.example.lab4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        val actionbar = supportActionBar
        actionbar!!.title = "Добавить";
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    public fun AddItem(view: View)
    {
        if (Validate() == false)
        {
            validationError.text = "Введите обязательные поля";
            return;
        }
        val intent = Intent();
        var item = TodoItem(header.text.toString(), todoBody.text.toString())
        intent.putExtra("item", item);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    private fun Validate() : Boolean
    {
        if (header.text.isNullOrEmpty())
        {
            return false;
        }
        return true;
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed();
        return true;
    }
}