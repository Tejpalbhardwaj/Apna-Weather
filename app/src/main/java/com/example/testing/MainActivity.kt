package com.example.testing

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.testing.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val API_KEY = "ed9b4e59381048e1afa114614251301"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Click Search Icon to fetch data
        binding.searchLayout.setEndIconOnClickListener {
            val city = binding.etSearch.text.toString()
            if (city.isNotEmpty()) {
                fetchWeather(city)
            } else {
                Toast.makeText(this, "Please enter a city name", Toast.LENGTH_SHORT).show()
            }
        }

        // 2. Press "Enter" on keyboard to fetch data
        binding.etSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                val city = binding.etSearch.text.toString()
                fetchWeather(city)
                true
            } else false
        }

        // Default city on app start
        fetchWeather("Rohtak")
    }

    private fun fetchWeather(city: String) {

        val api = RetrofitClient.instance.create(WeatherApi::class.java)

        // The 'response' variable is defined right here in the parameters
        api.getCurrentWeather(API_KEY, city).enqueue(object : Callback<WeatherResponse> {
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful) {
                    val weather = response.body()

                    weather?.let {
                        // Main Display
                        binding.tvCityName.text = it.location.name
                        binding.tvTemp.text = "${it.current.temp_c.toInt()}°"

                        // The 4 Info Boxes
                        binding.tvCondition.text = it.current.condition.text
                        binding.tvHumidity.text = "${it.current.humidity}%"
                        binding.tvWind.text = "${it.current.wind_kph} km/h"
                        binding.tvFeelsLike.text = "${it.current.temp_c}°C"

                        // Load high-quality icon
                        val iconUrl = "https:" + it.current.condition.icon.replace("64x64", "128x128")
                        Glide.with(this@MainActivity)
                            .load(iconUrl)
                            .into(binding.ivIcon)
                    }
                } else {
                    Toast.makeText(this@MainActivity, "City not found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Network Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}