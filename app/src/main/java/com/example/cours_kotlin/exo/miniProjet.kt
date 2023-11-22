package com.example.cours_kotlin.exo

import kotlin.random.Random

fun main() {
    val weatherloader = WeatherAPI.loadWeather("Guerville")
    println("Il fait ${weatherloader.main.temp}°C à ${weatherloader.name} avec un vent de ${weatherloader.wind.speed} m/s")

    val userloader = RandomUserAPI.loadUser()
    if (userloader.coord?.mail != null && userloader.coord?.phone != null)
        println("L'utilisateur est ${userloader.name}, agé de ${userloader.age} ans et contactable sur ${userloader.coord?.mail} et au ${userloader.coord?.phone}")
    else if (userloader.coord?.mail != null)
        println("L'utilisateur est ${userloader.name}, agé de ${userloader.age} ans et contactable sur ${userloader.coord?.mail}")
    else if (userloader.coord?.phone != null)
        println("L'utilisateur est ${userloader.name}, agé de ${userloader.age} ans et contactable au ${userloader.coord?.phone}")
    else
        println("L'utilisateur est ${userloader.name}, agé de ${userloader.age} ans")
}
