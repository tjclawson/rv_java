package com.tjclawson.rv_kotlin.data

class SwapiResponse(
    val count: Int,
    val next: String,
    val previous: String,
    val results: MutableList<Person>
)