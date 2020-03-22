package sample.coroutines.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import sample.coroutines.log
import kotlin.system.measureTimeMillis

private fun foo(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100) // 假装我们异步等待了 100 毫秒
        log(i.toString())
        emit(i) // 发射下一个值
    }
}

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        foo()
            .buffer()
            .collect { value ->
            delay(300) // 假装我们花费 300 毫秒来处理它
            println(value)
        }
    }
    println("Collected in $time ms")
}