package com.tjclawson.rv_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tjclawson.rv_kotlin.data.Person
import kotlinx.android.synthetic.main.person_list_view.view.*

class PersonListAdapter(private var personList: MutableList<Person>,
                        private val onItemClicked: (position: Int) -> Unit)
    : RecyclerView.Adapter<PersonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_list_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = personList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(personList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(person: Person) = with(itemView) {
            this.list_view_name.text = person.name
            this.setOnClickListener {
                onItemClicked.invoke(adapterPosition)
            }
        }
    }
}