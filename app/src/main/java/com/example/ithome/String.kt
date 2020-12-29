package com.example.ithome

import kotlin.text.StringBuilder

fun main() {
    val money1 = Money(6)
    val money2 = Money(5)
    println((money1+money2).value)
    println((money1+10).value)
    println("字符串"*5)
}

operator fun String.times(i:Int):String{
    val builder = StringBuilder()
    repeat(i){
        builder.append(this)
    }
    return builder.toString()
}

class Money (val value:Int){
    operator fun  plus(money: Money):Money{
        val sum:Int = value + money.value
        return Money(sum)
    }

    operator fun plus(i:Int):Money{
        val sum :Int = value + i
        return Money(sum)
    }
}