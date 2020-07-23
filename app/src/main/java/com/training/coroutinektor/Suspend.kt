package com.training.coroutinektor

import kotlinx.coroutines.*
import kotlinx.coroutines.launch
import kotlin.coroutines.*

var continuation: Continuation<Int>? = null

// Working Explanation
fun main() = runBlocking {
    launch(Dispatchers.Unconfined) {
        val a = a()
        println("Result is $a")
    }
    10.downTo(0).forEach {
        println("for loop it is $it")
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
