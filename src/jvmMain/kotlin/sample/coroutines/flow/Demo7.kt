package sample.coroutines.flow

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun numbers(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)
    } finally {
        println("Finally in numbers")
    }
}

fun main() = runBlocking<Unit> {
    numbers()
        .take(2) // 只获取前两个
        .collect { value -> println(value) }


    val sum = (1..5).asFlow()
        .map { it * it } // 数字 1 至 5 的平方
        .reduce { a, b ->
            println("$a and $b")
            a + b
        } // 求和（末端操作符）
}