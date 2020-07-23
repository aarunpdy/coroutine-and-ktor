package com.training.coroutinektor

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


private fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking {
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100)
        }
    }

    simple().collect { value -> println(value) }
}
