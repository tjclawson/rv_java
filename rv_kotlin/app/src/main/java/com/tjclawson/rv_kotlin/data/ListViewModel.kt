package com.tjclawson.rv_kotlin.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tjclawson.rv_kotlin.SwapiService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {

    val selectedPerson = MutableLiveData<Person>()
    val personList = MutableLiveData<MutableList<Person>>()
    private val swapiService = SwapiService()

    init {
        getAllPersons()
    }

    fun selectPerson(position: Int) {
        selectedPerson.postValue(personList.value?.get(position))
    }

    private fun getAllPersons() {
        GlobalScope.launch {
            personList.postValue(swapiService.getAllPeople().results)
        }
    }
}
