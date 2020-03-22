package sample.coroutines.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

private fun foo(): Flow<Int> = flow {
    for (i in 1..3) {
        try {
            delay(100)
        } catch (e: Throwable) {
            println(e)
        }
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    withTimeoutOrNull(250) {
        // 在 250 毫秒后超时
        foo().collect { value -> println(value) }
    }
    println("Done")
}