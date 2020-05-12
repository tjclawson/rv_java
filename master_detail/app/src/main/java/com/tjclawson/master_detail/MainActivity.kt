package com.tjclawson.master_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        if (frame_item_detail != null) viewModel.twoPane = true
        initUI()
    }

    private fun initUI() {
        if (viewModel.twoPane) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_item_list, ListFragment())
                    .replace(R.id.frame_item_detail, DetailFragment())
                    .commit()
        } else {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.list_container, ListFragment())
                    .commit()
        }
    }
}
