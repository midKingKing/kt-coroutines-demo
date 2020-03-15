package sample.coroutines.async

import kotlinx.coroutines.*
import sample.coroutines.printFormatMsg


object CompoundUsage {
    fun test() {
        val job1 = GlobalScope.launch(Dispatchers.Unconfined, CoroutineStart.LAZY) {
            var count = 0
            while (true) {
                count++
                delay(500)
                printFormatMsg("count::$count")
            }
        }

        val job2 = GlobalScope.async {
            job1.start()
            "Producer start"
        }

        GlobalScope.launch {
            printFormatMsg(job2.await())
            delay(3000)
            job1.cancel()
        }
    }
}

fun main() {
    runBlocking {
        CompoundUsage.test()
        delay(7000)
    }
}