package sample.coroutines.basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch { doWorld() }
    println("Hello, ${Thread.currentThread().name}")
}

suspend fun doWorld() {
    delay(1000)
    println("World! ${Thread.currentThread().name}")
}