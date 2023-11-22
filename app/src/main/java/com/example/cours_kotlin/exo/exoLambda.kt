package com.example.cours_kotlin.exo

fun main(){
    exo2()
}

fun exo1(){
    val lower : (String) -> Unit = {println(it.lowercase())}
    val heure : (Double) -> Double = {it/60}
    val max : (Int, Int) -> Int = {a,b -> a.coerceAtLeast(b) }
    val reverse : (String) -> String = {it.reversed()}
    val minToMinHour : (Int) -> Pair<Int, Int> = {Pair(it/60, it%60)}

    lower("GRAND TEXTE")
    println(heure(126.0))
    println(max(40,32))
    println(reverse("Enorme blague"))
    println("${minToMinHour(126).first},${minToMinHour(126).second}")

}

data class PersonBean(var name:String, var note:Int)

fun exo2(){
    val list = arrayListOf(PersonBean ("toto", 16),
        PersonBean ("Tata", 20),
        PersonBean ("Toto", 8),
        PersonBean ("Charles", 14))

    println("Afficher la sous liste de personne ayant 10 et +")
    //println(list.filter { it.note >=10 })
    //Pour un affichage de notre choix
    println(list.filter { it.note >=10 }.joinToString("\n") { "-${it.name} : ${it.note}"})

    //TODO
    println("\n\nAfficher combien il y a de Toto dans la classe ?")
    println(list.count{it.name.equals("toto", true)})

    println("\n\nAfficher combien de Toto ayant la moyenne (10 et +)")
    println(list.filter{it.name.equals("toto", true)}.count{it.note >= 10})

    println("\n\nAfficher combien de Toto ont plus que la moyenne de la classe")
    val average = list.map{it.note}.average()
    println(list.filter{it.name.equals("toto", true)}.count{it.note >= average})

    println("\n\nAfficher la list triée par nom sans doublon")
    println(list.distinctBy{it.name.lowercase()}.sortedBy{it.name}.joinToString ("\n"){ it.name })

    println("\n\nAjouter un point a ceux n’ayant pas la moyenne (<10)")
    list.filter{it.note < 10}.forEach{it.note++}
    println(list.joinToString("\n") { "-${it.name} : ${it.note}"})

    println("\n\nAjouter un point à tous les Toto")
    list.filter{it.name.equals("toto", true)}.forEach{it.note++}
    println(list.joinToString("\n") { "-${it.name} : ${it.note}"})

    println("\n\nRetirer de la liste ceux ayant la note la plus petite. (Il faut une ArrayList)")
    val min = list.minOfOrNull { it.note }
    list.removeIf{it.note == min}
    println(list.joinToString("\n") { "-${it.name} : ${it.note}"})

    println("\n\nAfficher les noms de ceux ayant la moyenne(10et+) par ordre alphabétique")
    println(list.filter{it.note >= 10}.sortedBy{it.name}.joinToString("\n") { "-${it.name} : ${it.note}"})
}