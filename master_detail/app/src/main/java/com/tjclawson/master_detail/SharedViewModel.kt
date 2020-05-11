package com.tjclawson.master_detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    val selected = MutableLiveData<Item>()
    val items = MutableLiveData<MutableList<Item>>()

    init {
        initItems()
    }

    fun selectItem(itemId: Int) {
        selected.postValue(items.value?.get(itemId))
    }

    private fun initItems() {
        val list = mutableListOf<Item>()
        list.add(Item(1, "description 1"))
        list.add(Item(2, "description 2"))
        list.add(Item(3, "description 3"))
        list.add(Item(4, "description 4"))
        list.add(Item(5, "description 5"))
        list.add(Item(6, "description 6"))
        list.add(Item(7, "description 7"))
        list.add(Item(8, "description 8"))
        list.add(Item(9, "description 9"))
        list.add(Item(10, "description 10"))
        list.add(Item(10, "description 10"))
        list.add(Item(11, "description 11"))
        list.add(Item(12, "description 12"))
        list.add(Item(13, "description 13"))
        list.add(Item(14, "description 14"))
        list.add(Item(15, "description 15"))
        list.add(Item(16, "description 16"))

        items.postValue(list)
    }
}