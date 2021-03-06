package sample.coroutines.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("World! ${Thread.currentThread().name}")
    }
    println("Hello, ${Thread.currentThread().name}")
    Thread.sleep(2000)
}