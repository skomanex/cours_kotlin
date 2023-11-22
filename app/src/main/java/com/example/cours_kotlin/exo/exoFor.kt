package com.example.cours_kotlin.exo

fun main(){
    println(destroyE("une phrase sans e c'est très marrant n'est-ce pas?"))
    println(aCount("allons compter les a dans cette phrase, ici il devrait y en avoir six"))
    println(inverseSentence("En inversant ceci on en parlerai presque verlan"))
    val randomName = RandomName()
    randomName.add("Bobby")
    repeat(10) {
        print(randomName.next() + " ")
    }
}

fun destroyE(sentence:String):String{
    println(sentence)
    var result = ""
    for(c in sentence)
    {
        if (c != 'e')
            result += c
    }
    return result
}

fun aCount(sentence:String):Int{
    println(sentence)
    var result = 0
    for (c in sentence){
        if(c == 'a')
            result += 1
    }
    return result
}

fun inverseSentence(sentence:String):String{
    println(sentence)
    var result = ""
    for(c in sentence)
    {
        result = c + result
    }
    return result
}

