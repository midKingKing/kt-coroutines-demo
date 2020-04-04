package sample.coroutines.local

import kotlinx.coroutines.*
import sample.coroutines.log
import kotlin.coroutines.*

class MyContinuationInterceptor : ContinuationInterceptor {
    override val key = ContinuationInterceptor
    override fun <T> interceptContinuation(continuation: Continuation<T>) = MyContinuation(continuation)
}

class My2ContinuationInterceptor : ContinuationInterceptor {
    companion object : CoroutineContext.Key<My2ContinuationInterceptor>
    override val key = My2ContinuationInterceptor
    override fun <T> interceptContinuation(continuation: Continuation<T>) = MyContinuation(continuation)
}

class MyContinuation<T>(val continuation: Continuation<T>) : Continuation<T> {
    override val context = continuation.context
    override fun resumeWith(result: Result<T>) {
        log("<MyContinuation> $result")
        continuation.resumeWith(result)
    }
}

suspend fun main() {
    GlobalScope.launch(MyContinuationInterceptor() + My2ContinuationInterceptor()) {
        log(1)
        val job = async {
            log(2)
            delay(1000)
            log(3)
            "Hello"
        }
        log(4)
        val result = job.await()
        log("5. $result")
    }.join()
    log(6)
    GlobalScope.launch {
        println(coroutineContext[Job]) // "coroutine#1":StandaloneCoroutine{Active}@1ff62014
    }
}