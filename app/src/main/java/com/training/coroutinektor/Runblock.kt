package com.training.coroutinektor

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlock()
}

private fun runBlock() = runBlocking {
    launch {
        print("Thread: ${Thread.currentThread().name}")
    }
}

