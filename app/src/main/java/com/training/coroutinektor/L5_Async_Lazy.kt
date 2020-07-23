package com.training.coroutinektor

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {

    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }

        println("doSomethingUsefulOne started")
        one.start()
        println("doSomethingUsefulTwo started")
        two.start()
        println("The answer is ${one.await() + two.await()}")
    }

    println("Completed in $time ms")
}

private suspend fun doSomethingUsefulOne(): Int {
    delay(1_000)
    println("doSomethingUsefulOne")
    return 55
}

private suspend fun doSomethingUsefulTwo(): Int {
    println("doSomethingUsefulTwo")
    delay(1_000)
    return 33
}
