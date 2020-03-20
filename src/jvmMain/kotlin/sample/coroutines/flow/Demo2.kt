package sample.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private suspend fun foo(): List<Int> {
    delay(1000) // 假装我们在这里做了一些异步的事情
    return listOf(1, 2, 3)
}

fun main() = runBlocking<Unit> {
    foo().forEach { value -> println(value) }
}