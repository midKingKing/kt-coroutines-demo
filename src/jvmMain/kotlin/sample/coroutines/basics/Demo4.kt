package sample.coroutines.basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//suspend fun main() {
//    val job = GlobalScope.launch {
//        delay(1000)
//        println("World! ${Thread.currentThread().name}")
//    }
//    println("Hello, ${Thread.currentThread().name}")
//    job.join()
//}

//在这个作用域中启动协程而无需显式 join ，因为外部协程（runBlocking）直到在其作用域中启动的所有协程都执行完毕后才会结束
fun main() = runBlocking {
    launch {
        delay(1000)
        println("World!  ${Thread.currentThread().name}")
    }
    println("Hello,  ${Thread.currentThread().name}")
}