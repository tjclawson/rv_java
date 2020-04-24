package com.tjclawson.rv_last_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var modelList: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
    }

    private fun initRecycler() {
        val myAdapter = ModelAdapter {position, adapter ->
            adapter.removeItem(position)
        }

        recycler_view_main.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = myAdapter
        }

        initList()
        myAdapter.submtiList(modelList)
    }

    private fun initList() {
        modelList = mutableListOf()
        modelList.add(Model("name1", "desc1"))
        modelList.add(Model("name2", "desc2"))
        modelList.add(Model("name3", "desc3"))
        modelList.add(Model("name4", "desc4"))
        modelList.add(Model("name5", "desc5"))
        modelList.add(Model("name6", "desc6"))
        modelList.add(Model("name7", "desc7"))
        modelList.add(Model("name8", "desc8"))
        modelList.add(Model("name9", "desc9"))
        modelList.add(Model("name10", "desc10"))
        modelList.add(Model("name11", "desc11"))
        modelList.add(Model("name12", "desc12"))
        modelList.add(Model("name13", "desc13"))
        modelList.add(Model("name14", "desc14"))
    }
}
