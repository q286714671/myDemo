package com.example.yongqi.demo.testkt

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main(arg:Array<String>){

    var a : Array<String> = arrayOf("4","0","7","i","f","w","0","9")

    var index :Array<Int> = arrayOf(5,3,9,4,8,3,1,9,2,1,7)

    index.filter { it < a.size }
            .map { a[it] }
            .reduce { acc, s ->
                "$acc$s"
            }.also { println("密码是：$it")}


    suspend fun main() = coroutineScope {
        launch {
            delay(1000)
            println("Kotlin Coroutines World!")
        }
        println("Hello")
    }
}