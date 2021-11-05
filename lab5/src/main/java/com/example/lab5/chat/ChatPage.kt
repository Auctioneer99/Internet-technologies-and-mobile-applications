package com.example.lab5

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab5.chat.ChatAddMessageActivity
import com.example.lab5.chat.lib.*
import kotlinx.android.synthetic.main.page_chat.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ChatFragment(private val _messageProvider: IMessageProvider) : Fragment() {
    private val _container: MessageContainer = MessageContainer();

    private val _addResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult(), ActivityResultCallback{
        if (it.resultCode == AppCompatActivity.RESULT_OK) {
            var message: Message? = it.data?.getParcelableExtra<Message>("message");
            if (message != null) {
                GlobalScope.launch {
                    _messageProvider.AddMessage(message);
                    UpdateMessages();
                }
            }
        }
    });

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        val view = inflater.inflate(R.layout.page_chat, container, false);
        (activity as AppCompatActivity).setSupportActionBar(toolbar);
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.setOnMenuItemClickListener(::onItemSelected);
        recycler.apply {
            adapter = Adapter(_container)
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        };
        GlobalScope.launch {
            UpdateMessages();
        }
    }

    private fun onItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.create_message) {
            _addResultLauncher.launch(Intent(context, ChatAddMessageActivity::class.java));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private suspend fun UpdateMessages() = coroutineScope {
        val messages = async { _messageProvider.GetLastMessages() }.await();
        activity?.runOnUiThread {
            _container.Clear();
            for (m in messages)
            {
                _container.Add(m);
            }
        }

    }
}