package com.tjclawson.rv_kotlin

import com.tjclawson.rv_kotlin.Person

class SwapiResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: MutableList<Person>
)