package com.tjclawson.master_detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_view.view.*

class SampleAdapter(private val onItemClicked: (position: Int) -> Unit) : RecyclerView.Adapter<SampleAdapter.ViewHolder>() {

    private var itemList = mutableListOf<Item>()
    private var lastSelected: Int? = null
    private var selected: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun submitList(list: MutableList<Item>) {
        itemList.clear()
        itemList.addAll(list)
        this.notifyDataSetChanged()
    }

    private fun selectItem(position: Int) {
        lastSelected = selected
        selected = position
        this.notifyItemChanged(position)
        lastSelected?.let { this.notifyItemChanged(it) }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item) = with(itemView) {
            this.tv_title.text = item.title
            if (adapterPosition == selected) this.cv_parent.setBackgroundColor(resources.getColor(R.color.colorAccent))
            this.setOnClickListener {
                onItemClicked.invoke(adapterPosition)
                selectItem(adapterPosition)
            }
        }
    }
}