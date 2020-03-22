package sample.coroutines

fun printFormatMsg(string: String) {
    println(string.plus(" [${Thread.currentThread().name}] "))
}

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")
