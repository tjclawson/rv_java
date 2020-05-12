package com.tjclawson.master_detail

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_view.view.*

class SampleAdapter(private val onItemClicked: (position: Int) -> Unit) : RecyclerView.Adapter<SampleAdapter.ViewHolder>() {

    private var itemList = mutableListOf<Item>()
    private var selected: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = itemList[position]
        holder.titleView.text = data.title
        if (selected == position) holder.parent.setCardBackgroundColor(Color.RED)
        else holder.parent.setCardBackgroundColor(Color.WHITE)
        holder.parent.setOnClickListener {
            selectItem(position)
            onItemClicked.invoke(position)
        }
    }

    fun submitList(list: MutableList<Item>) {
        itemList.clear()
        itemList.addAll(list)
        this.notifyDataSetChanged()
    }

    private fun selectItem(position: Int) {
        val lastSelected = selected
        selected = position
        selected?.let { notifyItemChanged(it) }
        lastSelected?.let { notifyItemChanged(it) }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val parent: CardView = itemView.cv_parent
        val titleView: TextView = itemView.tv_title
    }
}