package com.shvatov.tasks.other

import kotlin.system.measureNanoTime

val sieveSequence = generateSequence(listOf(2)) { primes ->
    var current = primes.last()
    while (primes.any { current % it == 0 }) current += 1
    primes + current
}

val suggestedSieveSequence = sequence {
    var numbers = generateSequence(2) { it + 1 }
    while (true) {
        val prime = numbers.first()
        yield(prime)
        numbers = numbers.drop(1)
            .filter { it % prime != 0 }
    }
}

/**
 * On 100 elements the results are:
 * sieveSequence - 89.446.070 ns
 * suggestedSieveSequence - 5.633.254.894 ns
 */
fun main() {
    measureNanoTime {
        sieveSequence
            .take(1000)
            .last()
            .also { println(it) }
    }.also {
        println("$it ns")
    }

    measureNanoTime {
        suggestedSieveSequence
            .take(1000)
            .also { println(it.toList()) }
    }.also {
        println("$it ns")
    }
}