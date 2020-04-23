package com.tjclawson.rv_kotlin.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tjclawson.rv_kotlin.R
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailFragment() : Fragment() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(activity!!).get(SharedViewModel::class.java)

        viewModel.selectedPerson.observe(viewLifecycleOwner, Observer {
            it?.let {
                tv_name.text = it.name
                tv_height.text = it.height
                tv_mass.text = it.mass
            }
        })
    }
}