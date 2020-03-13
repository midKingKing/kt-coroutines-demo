package sample.coroutines.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    GlobalScope.launch {
        delay(1000)
        println("World!  ${Thread.currentThread().name}")
    }

    println("Hello, ${Thread.currentThread().name}")
    delay(2000)
}