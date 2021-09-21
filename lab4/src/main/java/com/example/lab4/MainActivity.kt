package com.example.lab4

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var _container: TodoContainer = TodoContainer();
    private var _addResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(), ActivityResultCallback{
        if (it.resultCode == RESULT_OK) {
            var item: TodoItem? = it.data?.getParcelableExtra<TodoItem>("item");
            if (item != null) {
                _container.Add(item);
            }
        }
    });
    private var _observeResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(), ActivityResultCallback{
        if (it.resultCode == RESULT_OK) {
            var position: Int = it.data?.getIntExtra("index", -1)?: -1;
            _container.Remove(position);
        }
    });

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        supportActionBar?.title = "Список дел";
        recycler_todo.apply {
            adapter = Adapter(_container)
            {
                view, position, todoItem -> ObserveTodo(position, todoItem);
            }
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        };
    }

    public fun AddTodo(view: View)
    {
        _addResultLauncher.launch(Intent(this, AddActivity::class.java));
    }

    private fun ObserveTodo(position: Int, item: TodoItem)
    {
        _observeResultLauncher.launch(Intent(this, ObserveActivity::class.java)
            .putExtra("index", position)
            .putExtra("item", item)
        );
    }
}