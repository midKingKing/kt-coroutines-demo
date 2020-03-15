package sample.coroutines.combination_and_suspend

import kotlinx.coroutines.delay
import sample.coroutines.printFormatMsg


suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // 假设我们在这里做了一些有用的事
    printFormatMsg("doSomethingUsefulOne() ")
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // 假设我们在这里也做了一些有用的事
    printFormatMsg("doSomethingUsefulTwo() ")
    return 29
}