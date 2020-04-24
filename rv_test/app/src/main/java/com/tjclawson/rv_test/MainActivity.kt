package com.tjclawson.rv_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()
        initRecycler()
    }

    private fun initRecycler() {
        val myAdapter = TestAdapter {
            Toast.makeText(this, list[it], Toast.LENGTH_LONG).show()
        }

        rv_main.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = myAdapter
        }

        myAdapter.submitList(list)
    }

    private fun initList() {
        list.add("test1")
        list.add("test12")
        list.add("test13")
        list.add("test14")
        list.add("test15")
        list.add("test16")
        list.add("test17")
        list.add("test18")
        list.add("test19")
        list.add("test10")
        list.add("test112")
    }
}
