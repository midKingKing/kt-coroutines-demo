package sample.coroutines.cancel_and_timeout

import kotlinx.coroutines.*
import sample.coroutines.printFormatMsg

fun main() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                printFormatMsg("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable) {
                printFormatMsg("job: I'm running finally")
                delay(5000L)
                printFormatMsg("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L) // 延迟一段时间
    printFormatMsg("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消该作业并等待它结束
    printFormatMsg("main: Now I can quit.")
}