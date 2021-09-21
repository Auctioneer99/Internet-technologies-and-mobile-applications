package com.example.lab4

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_observe.*
import kotlinx.android.synthetic.main.activity_observe.header

class ObserveActivity : AppCompatActivity()
{
    private var _position: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observe);

        val actionbar = supportActionBar;
        actionbar!!.title = "Подробнее";
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setDisplayHomeAsUpEnabled(true);
        var item: TodoItem? = intent!!.getParcelableExtra<TodoItem>("item");
        header.text = item!!.Header;
        body.text = item.Body;
        _position = intent.getIntExtra("index", -1);
    }

    public fun FinishTodo(view: View)
    {
        val builder = AlertDialog.Builder(this);
        builder.setTitle("Поздравляем");
        builder.setMessage("Задача выполнена.");
        builder.setNeutralButton(android.R.string.ok) { dialog, which ->
            val intent = Intent();
            intent.putExtra("index", _position);
            setResult(Activity.RESULT_OK, intent);
            finish();
        };
        builder.show();
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed();
        return true;
    }
}