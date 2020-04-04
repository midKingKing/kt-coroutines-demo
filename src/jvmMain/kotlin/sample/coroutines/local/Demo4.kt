package sample.coroutines.local

import kotlinx.coroutines.*
import sample.coroutines.log

suspend fun main() {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        log("${coroutineContext[CoroutineName]} $throwable")
    }

    log(1)
    try {
        supervisorScope { //①
            log(2)
            launch(exceptionHandler + CoroutineName("2")) { // ②
                log(3)
                launch(exceptionHandler + CoroutineName("3")) { // ③
                    log(4)
                    delay(500)
                    log("ready throw exp")
                    throw ArithmeticException("Hey!!")
                }
                log(5)
            }
            log(6)
            val job = launch { // ④
                log(7)
                delay(1000)
            }
            try {
                log(8)
                job.join()
                log("9")
            } catch (e: Exception) {
                log("10. $e")
            }
            log(10.5)
        }
        log(11)
    } catch (e: Exception) {
        log("12. $e")
    }
    log(13)
}