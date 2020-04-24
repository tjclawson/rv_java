package com.tjclawson.rv_last_test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.model_list_view.view.*

class ModelAdapter(private val onItemClick: (position: Int, adapter: ModelAdapter) -> Unit) : RecyclerView.Adapter<ModelAdapter.ViewHolder>() {

    private val modelList = mutableListOf<Model>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.text_view_name
        val descView: TextView = view.text_view_desc
        val parentView: CardView = view.parent_card

        fun bind(model: Model) {
            this.nameView.text = model.name
            this.descView.text = model.desc
            this.parentView.setOnClickListener {
                onItemClick.invoke(adapterPosition, this@ModelAdapter)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.model_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = modelList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(modelList[position])
    }

    fun submtiList(newList: MutableList<Model>) {
        modelList.clear()
        modelList.addAll(newList)
        this.notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        modelList.removeAt(position)
        this.notifyItemRemoved(position)
    }
}