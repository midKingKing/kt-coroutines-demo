package sample.coroutines.async

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import sample.coroutines.printFormatMsg

object CommonUsage {

    suspend fun suspendFun1(param : Int) : Int {
        printFormatMsg("enter suspendFun1()")
        val result = GlobalScope.async {
            suspendFun2(param)
        }
        printFormatMsg("done suspendFun1()")
        return result.await() + 33
    }

    suspend fun suspendFun2(param : Int) : Int {
        printFormatMsg("enter suspendFun2()")
        delay(1000)
        printFormatMsg("done suspendFun2()")
        return 15 + param
    }

}

fun main() {
    printFormatMsg("enter test")
    runBlocking {
        printFormatMsg("result in runBlocking is ${CommonUsage.suspendFun1(1)}")
    }
    printFormatMsg("done test")
}