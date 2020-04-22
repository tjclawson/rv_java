package com.tjclawson.rv_kotlin.data

data class Pokemon(
    val id: Int,
    val name: String,
    val sprites: MutableList<String>,
    val height: Int,
    val weight: Int
)