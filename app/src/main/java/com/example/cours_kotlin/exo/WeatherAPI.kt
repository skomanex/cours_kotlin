package com.example.cours_kotlin.exo

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

object WeatherAPI {
    private val client = OkHttpClient()
    private val gson = Gson()

    fun loadWeather(ville:String = "Paris"): WeatherBean {
        //Eventuel contrôle
        //Réaliser la requête.
        val json: String = sendGet("https://api.openweathermap.org/data/2.5/weather?q=${ville}&appid=b80967f0a6bd10d23e44848547b26550&units=metric&lang=fr")

        //Parser le JSON avec le bon bean et GSON
        val data : WeatherBean = gson.fromJson(json, WeatherBean::class.java)

        //Eventuel contrôle ou extraction de données

        //Retourner la donnée
        return data
    }

    //Méthode qui prend en entrée une url, execute la requête
    //Retourne le code HTML/JSON reçu
    fun sendGet(url: String): String {
        println("url : $url")
        //Création de la requête
        val request = Request.Builder().url(url).build()
        //Execution de la requête
        return client.newCall(request).execute().use { //it:Response
            //use permet de fermer la réponse qu'il y ait ou non une exception
            //Analyse du code retour
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            //Résultat de la requête
            it.body.string()
        }
    }
}