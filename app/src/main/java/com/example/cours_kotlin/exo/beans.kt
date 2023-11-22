package com.example.cours_kotlin.exo

import java.util.Random

class CarBean(var brand:String = "-", var model:String = "-"){
    var color:String? = null

    public override fun toString(): String {
        return "CarBean{Marque: $brand, Modèle: $model, Couleur: $color}"
    }
}

class HouseBean(private var color:String = "-", length:Double, width:Double){
    private var surface:Double = length*width
    fun print(){
        println("La maison $color fait $surface m²")
    }
}

class TownBean(var city:String = "-", var postalcode:Int? = null){
    var country:String = "-"
}

data class DataTownBean(var city:String = "-", var postalcode:Int? = null){
    var country:String = "-"
}

class PrintRandomIntBean(private var max:Int){
    private var random:Random = Random()
    init{
        println(random.nextInt(max))
        println(random.nextInt(max))
        println(random.nextInt(max))
    }
    constructor() : this(100){
        println(random.nextInt(max))
    }
}

class ThermometerBean(private var min:Int, private var max:Int, value:Int){
    var value = value
        set(value){
            if(value < min)
            {
                field = min
            }
            else if(value > max)
            {
                field = max
            }
            else{
                field = value
            }
        }
    init {
        this.value = value
    }
}

data class WeatherBean(var name:String, var main:TempBean, var wind:WindBean)

data class TempBean(var temp:Double)

data class WindBean(var speed:Double)

data class RandomBean(var name:String, var age:Int, var coord:ContactBean?)

data class ContactBean(var phone:String?, var mail:String?)

class RandomName(){
    private var noms = arrayListOf("Léo","Ana","Tom")
    private var oldValue:String = ""
    fun add(nom:String?) = if(!nom.isNullOrBlank() && nom !in noms) noms.add(nom) else false
    fun next():String = noms.random()
    fun nextDiff():String{
        var newValue:String = next()
        while (newValue == oldValue)
            newValue = next()
        oldValue = newValue
        return newValue
    }
    fun nextDiffv2():String = noms.filter{it != oldValue}.random().also{oldValue = it}
}

const val LONG_TEXT = """Le Lorem Ipsum est simplement
    du faux texte employé dans la composition
    et la mise en page avant impression.
    Le Lorem Ipsum est le faux texte standard
    de l'imprimerie depuis les années 1500"""
data class PictureData(val url: String, val text: String, val longText: String)

//jeu de donnée
val pictureList = arrayListOf(PictureData("https://picsum.photos/200", "ABCD", LONG_TEXT),
    PictureData("https://picsum.photos/201", "BCDE", LONG_TEXT),
    PictureData("https://picsum.photos/202", "CDEF", LONG_TEXT),
    PictureData("https://picsum.photos/203", "EFGH", LONG_TEXT)
)