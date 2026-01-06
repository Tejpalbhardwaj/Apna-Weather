package com.example.testing

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/current.json")
    fun getCurrentWeather(
        @Query("key") apiKey: String,
        @Query("q") city: String,
        @Query("aqi") aqi: String = "no"
    ): Call<WeatherResponse>
}