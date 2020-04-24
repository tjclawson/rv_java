package com.tjclawson.rv_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.test_list_view.view.*

class TestAdapter(private val onItemClicked: (position: Int) -> Unit) : RecyclerView.Adapter<TestAdapter.ViewHolder>() {

    private val testList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.test_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = testList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(testList[position])
    }

    fun submitList(list: MutableList<String>) {
        testList.clear()
        testList.addAll(list)
        this.notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nameView: TextView = view.text_view_name
        private val parentView: CardView = view.card_view_parent

        fun bind(test: String) {
            this.nameView.text = test
            this.parentView.setOnClickListener{
                onItemClicked.invoke(adapterPosition)
            }
        }
    }
}