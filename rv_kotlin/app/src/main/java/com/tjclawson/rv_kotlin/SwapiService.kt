package com.tjclawson.rv_kotlin

import com.tjclawson.rv_kotlin.data.SwapiResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SwapiService {

    companion object {

        const val BASE_URL = "https://swapi.dev/api/"

        operator fun invoke() =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SwapiService::class.java)
    }

    @GET("people")
    suspend fun getAllPeople(): SwapiResponse
}