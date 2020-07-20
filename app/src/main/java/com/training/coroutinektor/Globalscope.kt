package com.training.coroutinektor

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val deferred = (1..1_000).map { number ->
        GlobalScope.async {
            number
        }
    }

    val sum = deferred.map { it.await().toLong() }.sum()
    print("Sum: $sum")
}
