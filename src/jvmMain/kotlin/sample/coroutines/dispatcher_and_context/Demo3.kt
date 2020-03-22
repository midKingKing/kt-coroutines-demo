package sample.coroutines.dispatcher_and_context

import kotlinx.coroutines.*
import sample.coroutines.log

//vm options -Dkotlinx.coroutines.debug
@ObsoleteCoroutinesApi
fun main() = runBlocking {
    log("ready to exec")
    val a = async {
        log("I'm computing a piece of the answer")
        6
    }
    val b = async {
        log("I'm computing another piece of the answer")
        7
    }
    log("The answer is ${a.await() * b.await()}")
}