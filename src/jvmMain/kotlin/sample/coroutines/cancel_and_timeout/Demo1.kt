package sample.coroutines.cancel_and_timeout

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) {
                println("job: I'm sleeping $it ... ${Thread.currentThread().name}")
                delay(500L)
            }
        } catch (e: Throwable) {
            // JobCancellationException
            println(e)
        }
    }
    delay(1300)
    println("main: I'm tired of waiting! ${Thread.currentThread().name}")
    job.cancelAndJoin()
    println("main: Now I can quit. ${Thread.currentThread().name}")
}