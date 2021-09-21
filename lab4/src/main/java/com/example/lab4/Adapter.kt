package com.example.lab4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>
{
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(model: TodoItem) {
            itemView.apply{
                header.text = model.HeaderShortcut;
                body.text = model.BodyShortcut;
            }
        }
    }

    private var _onClickListener: (View, Int, TodoItem) -> Unit;
    private var _container: TodoContainer;

    constructor(container: TodoContainer, onClickListener: (View, Int, TodoItem) -> Unit) : super() {
        _container = container;
        _onClickListener = onClickListener;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_layout, parent, false)
        );
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val item = _container.Get(position);
        holder.bind(item);
        holder.itemView.setOnClickListener { view ->
            _onClickListener.invoke(view, position, item)
        };
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

    private fun OnContainerChanged(junk: Int)
    {
        notifyDataSetChanged();
    }
}