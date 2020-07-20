package com.training.coroutinektor

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

var continuation: Continuation<Int>? = null

// Working Explanation
fun main() = runBlocking {
    launch(Dispatchers.Unconfined) {
        val a = a()
        println("Result is $a")
    }
    10.downTo(0).forEach {
        println("it is $it")
        continuation!!.resume(it)
    }
}

suspend fun a(): Int {
    return b()
}

suspend fun b(): Int {
    while (true) {
        val i = suspendCoroutine<Int> { cont -> continuation = cont }
        println("i is $i")
        if (i == 0) {
            return 0
        }
    }
}
