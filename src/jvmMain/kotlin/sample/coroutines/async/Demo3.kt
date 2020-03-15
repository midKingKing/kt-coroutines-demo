package sample.coroutines.async

import kotlinx.coroutines.*
import sample.coroutines.printFormatMsg

object SuspendOrBlocking {

    suspend fun blocking(param: Int) {
        printFormatMsg("enter blocking() with $param")
        delay(5000)
        printFormatMsg("done blocking() with $param")
    }

    suspend fun separateAsync() {
        printFormatMsg("separateAsync()")
            val deferred1 = GlobalScope.async {
                blocking(1)
            }
            val deferred2 = GlobalScope.async {
                blocking(2)
            }
            val deferred3 = GlobalScope.async {
                blocking(3)
            }
            deferred1.await()
            deferred2.await()
            deferred3.await()
    }

    suspend fun separateLaunch() {
        printFormatMsg("separateLaunch()")
        withContext(Dispatchers.Default) {
            val job1 = GlobalScope.launch {
                blocking(4)
            }
            val job2 = GlobalScope.launch {
                blocking(5)
            }
            val job3 = GlobalScope.launch {
                blocking(6)
            }
            job1.join()
            job2.join()
            job3.join()
        }
    }
}

private fun testSuspendOrBlocking() {
    runBlocking {
        SuspendOrBlocking.separateAsync()
        SuspendOrBlocking.separateLaunch()
    }
    printFormatMsg("done test")
}

fun main() {
    testSuspendOrBlocking()
}