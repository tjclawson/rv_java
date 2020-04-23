package com.tjclawson.rv_kotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface SwapiService {

    companion object {

        const val BASE_URL = "https://swapi.dev/api/"
        private var instance: SwapiService? = null

        operator fun invoke(): SwapiService? {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(SwapiService::class.java)
            }
            return instance
        }
    }

    @GET("people")
    suspend fun getAllPeople(): SwapiResponse
}