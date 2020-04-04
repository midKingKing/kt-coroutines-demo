@file:JvmName(name = "LogKt")
package sample.coroutines

fun printFormatMsg(string: String) {
    println(string.plus(" [${Thread.currentThread().name}] "))
}

fun log(msg: Any) = println("[${Thread.currentThread().name}] ${msg.toString()}")
