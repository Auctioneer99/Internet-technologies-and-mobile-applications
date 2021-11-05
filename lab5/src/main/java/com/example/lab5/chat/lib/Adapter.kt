package com.example.lab5.chat.lib

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5.R
import kotlinx.android.synthetic.main.view_chat_message.view.*


class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>
{
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: Message) {
            itemView.apply{
                message_host.text = model.Host;
                message_text.text = model.Message;
            }
        }
    }

    private var _container: MessageContainer;

    constructor(container: MessageContainer) : super() {
        _container = container;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_chat_message, parent, false)
        );
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val item = _container.Get(position);
        holder.bind(item);
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        _container.Changed += ::OnContainerChanged;
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        _container.Changed -= ::OnContainerChanged;
    }

    override fun getItemCount(): Int = _container.Count;

    private fun OnContainerChanged(junk: Unit)
    {
        notifyDataSetChanged();
    }
}