package com.tjclawson.master_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    val items = MutableLiveData<MutableList<Item>>()
    val selected = MutableLiveData<Item>()
    var twoPane = false

    init {
        val list = mutableListOf<Item>()
        list.add(Item(1, "title 1", "description 1"))
        list.add(Item(2, "title 2", "description 2"))
        list.add(Item(3, "title 3", "description 3"))
        list.add(Item(4, "title 4", "description 4"))
        list.add(Item(5, "title 5", "description 5"))
        list.add(Item(6, "title 6", "description 6"))
        list.add(Item(7, "title 7", "description 7"))
        list.add(Item(8, "title 8", "description 8"))
        list.add(Item(9, "title 9", "description 9"))
        list.add(Item(11, "title 11", "description 11"))
        list.add(Item(12, "title 12", "description 12"))
        list.add(Item(13, "title 13", "description 13"))
        list.add(Item(14, "title 14", "description 14"))
        list.add(Item(15, "title 15", "description 15"))
        list.add(Item(16, "title 16", "description 16"))
        list.add(Item(17, "title 17", "description 17"))
        list.add(Item(18, "title 18", "description 18"))
        list.add(Item(19, "title 19", "description 19"))
        list.add(Item(20, "title 20", "description 20"))
        list.add(Item(21, "title 21", "description 21"))
        list.add(Item(22, "title 22", "description 22"))
        list.add(Item(23, "title 23", "description 23"))
        list.add(Item(24, "title 24", "description 24"))

        items.postValue(list)
    }

    fun selectItem(position: Int) {
        selected.postValue(items.value?.get(position))
    }

}