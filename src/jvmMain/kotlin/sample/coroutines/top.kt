package sample.coroutines

fun printFormatMsg(string: String) {
    println(string.plus(" [${Thread.currentThread().name}] "))
}