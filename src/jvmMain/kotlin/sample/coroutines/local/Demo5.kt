package sample.coroutines.local

import kotlinx.coroutines.*
import sample.coroutines.log

//suspend fun main() {
//    val deferred = GlobalScope.async<Int> {
//        throw ArithmeticException()
//    }
//    try {
//        deferred.join()
//        log(1)
//    } catch (e: Exception) {
//        log("2. $e")
//    }
//}

suspend fun main() {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        log("${coroutineContext[CoroutineName]} $throwable")
    }

    val job = GlobalScope.launch(exceptionHandler) {
        throw ArithmeticException()
    }
    try {
        job.join()
        log(1)
    } catch (e: Exception) {
        log("2. $e")
    }
}