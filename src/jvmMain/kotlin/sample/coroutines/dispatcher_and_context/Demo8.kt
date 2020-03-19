package sample.coroutines.dispatcher_and_context

import kotlinx.coroutines.*

//vm options -Dkotlinx.coroutines.debug

@ObsoleteCoroutinesApi
fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default + CoroutineName("test")) {
        println("I'm working in thread ${Thread.currentThread().name}")
    }
}
