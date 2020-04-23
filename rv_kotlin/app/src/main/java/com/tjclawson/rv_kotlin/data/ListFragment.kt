package com.tjclawson.rv_kotlin.data

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tjclawson.rv_kotlin.PersonListAdapter

import com.tjclawson.rv_kotlin.R
import kotlinx.android.synthetic.main.list_fragment.*

class ListFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel
    private var personList = mutableListOf<Person>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(activity!!).get(SharedViewModel::class.java)

        viewModel.personList.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                personList.clear()
                personList.addAll(it)
                recyclerview_persons.adapter!!.notifyDataSetChanged()
            }
        })

        recyclerview_persons.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PersonListAdapter(personList) {
                viewModel.selectPerson(it)
                activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, DetailFragment())
                    .commit()
            }
        }
    }
}
