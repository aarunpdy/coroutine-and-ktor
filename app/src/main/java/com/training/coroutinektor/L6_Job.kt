package com.training.coroutinektor

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

import kotlinx.coroutines.*

fun main() = runBlocking {

    val job = GlobalScope.launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")

    delay(2000L)
    //job.join()
}
