package sample.coroutines.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    GlobalScope.launch {
        delay(1000L)
        println("World! ${Thread.currentThread().name}")
    }
    runBlocking {
        // 调用了 runBlocking 的主线程会一直阻塞直到 runBlocking 内部的协程执行完毕。
        println("Hello, ${Thread.currentThread().name}")
        delay(2000L)
    }
}