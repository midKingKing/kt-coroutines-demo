package sample.coroutines.local

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import sample.coroutines.log

suspend fun main() {
    log(1)
    try {
        supervisorScope { //①
            log(2)
            launch { // ②
                log(3)
                launch { // ③
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