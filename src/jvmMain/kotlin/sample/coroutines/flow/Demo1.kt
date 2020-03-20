package sample.coroutines.flow

private fun foo(): Sequence<Int> = sequence { // 序列构建器
    for (i in 1..3) {
        Thread.sleep(1000) // 假装我们正在计算
        yield(i) // 产生下一个值
    }
}

fun main() {
    foo().forEach { value -> println(value) }
}