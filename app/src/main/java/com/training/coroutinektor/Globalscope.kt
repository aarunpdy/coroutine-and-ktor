package com.training.coroutinektor

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

// Run block example
fun main() = runBlocking {
    val deferred = (1..1_000).map { number ->
        GlobalScope.async {
            number
        }
    }

    val sum = deferred.map { it.await() }.sum()
    print("Sum: $sum")
}
