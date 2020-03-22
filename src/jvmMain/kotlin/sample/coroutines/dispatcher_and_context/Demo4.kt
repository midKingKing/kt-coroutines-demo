package sample.coroutines.dispatcher_and_context

import kotlinx.coroutines.*
import sample.coroutines.log

//vm options -Dkotlinx.coroutines.debug

@ObsoleteCoroutinesApi
fun main() = newSingleThreadContext("Ctx1").use { ctx1 ->
    newSingleThreadContext("Ctx2").use { ctx2 ->
        runBlocking(ctx1) {
            log("Started in ctx1")
            withContext(ctx2) {
                log("Working in ctx2")
            }
            log("Back to ctx1")
            println("My job is ${coroutineContext[Job]}")
        }
    }
}
