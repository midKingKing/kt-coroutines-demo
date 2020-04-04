@file:JvmName("SuspendTestKt")
package sample.coroutines.suspend

import sample.coroutines.log
import kotlin.concurrent.thread
import kotlin.coroutines.resume

suspend fun hello() = kotlin.coroutines.intrinsics.suspendCoroutineUninterceptedOrReturn<Int> { continuation ->
    log(1)
    thread {
        Thread.sleep(1000)
        log(2)
        continuation.resume(1024)
    }
    log(3)
    kotlin.coroutines.intrinsics.COROUTINE_SUSPENDED
}
