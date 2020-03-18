package sample.coroutines.dispatcher_and_context

import kotlinx.coroutines.*

//vm options -Dkotlinx.coroutines.debug

@ObsoleteCoroutinesApi
fun main() = runBlocking<Unit> {
    // 启动一个协程来处理某种传入请求（request）
    val request = launch {
        repeat(3) { i -> // 启动少量的子作业
            launch  {
                delay((i + 1) * 2000L) // 延迟 200 毫秒、400 毫秒、600 毫秒的时间
                println("Coroutine $i is done ${Thread.currentThread().name}")
            }
        }
        println("request: I'm done and I don't explicitly join my children that are still active")
    }
    request.join() // 等待请求的完成，包括其所有子协程
    println("Now processing of the request is complete")
}
