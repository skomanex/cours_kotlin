package com.example.cours_kotlin.exo

fun main() {
//    var v1 = "toto"
//    println(v1.uppercase())
//    var v2:String? = "toto"
//    println(v2?.uppercase())
//    var v3:String? = null
//    if(v3.isNullOrBlank())
//        v3 = "toto"
//    println(v3.uppercase())
//    var v4:String = v3 + v3
//    println(v4.uppercase())
//    println(min(-20,-3,0))
//    println(minExpression(4,8,-2))
//    println(pair(5))
//    myPrint("Hello")
//    println(boulangerie(nbCroissant = 2))
//    println(boulangerie(nbBaguette = 2, nbSandwich = 3))
//    var croissant:Int = scanNumber("Combien de croissants?:")
//    var baguette:Int = scanNumber("Combien de baguettes?:")
//    var sandwich:Int = scanNumber("Combien de sandwichs?:")
//    println(boulangerie(nbCroissant = croissant, nbSandwich = sandwich, nbBaguette = baguette))
    val car1 = CarBean("Seat","Leon")
    car1.color = "Gris"
    println(car1.toString())
    val maison = HouseBean("Noire",10.5,5.5)
    maison.print()
//    val town1 = TownBean("New York", 10001)
//    val town2 = TownBean("New Orleans", 70032)
//    val datatown1 = DataTownBean("New York", 10001)
//    val datatown2 = DataTownBean("New Orleans", 70032)
//    println(town1 == town2)
//    println(town1 === town2)
//    println(datatown1 == datatown2)
//    println(datatown1 === datatown2)
//    println(datatown1 == datatown1.copy())
//    val random = PrintRandomIntBean()
    val therm1 = ThermometerBean(-20,50,80)
    println(therm1.value)
    therm1.value = 70
    println(therm1.value)
    therm1.value = -45
    println(therm1.value)
}

fun min(a:Int, b:Int, c:Int):Int{
    if (a < b)
        return if(a < c)
            a
        else
            c
    return if(b < c)
        b
    else
        c
}

fun minExpression(a:Int, b:Int, c:Int):Int = if(a < b && a <c) a else if(b < a && b < c) b else c

fun pair(a:Int):Boolean = a%2 == 0

fun myPrint(chaine:String) = println("#$chaine#")

fun boulangerie(nbCroissant:Int = 0, nbBaguette:Int = 0, nbSandwich:Int = 0) =
    PRIX_CROISSANT*nbCroissant + PRIX_BAGUETTE*nbBaguette + PRIX_SANDWHICH*nbSandwich

fun scanText(question:String):String{
    println(question)
    return(readlnOrNull() ?: "-");
}

fun scanNumber(question:String):Int{
    println(question)
    return(readlnOrNull()?.toIntOrNull() ?: 0)
}