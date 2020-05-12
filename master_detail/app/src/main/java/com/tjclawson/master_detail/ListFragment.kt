package com.tjclawson.master_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val itemAdapter = SampleAdapter {
            selectItem(it)
        }

        rv_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = itemAdapter
        }

        viewModel.items.observe(viewLifecycleOwner, Observer {
            if (it != null) itemAdapter.submitList(it)
        })
    }

    private fun selectItem(position: Int) {

        viewModel.selectItem(position)

        if (!viewModel.twoPane) {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.list_container, DetailFragment())
                .commit()
        }
    }
}
