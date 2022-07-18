package com.shvatov.hacker.rank.easy.arrays

data class Element<T : Any>(val value: T) {
    lateinit var next: Element<T>
}

class LinkedArray<T : Any>(array: Array<T>) {
    private var head: Element<T>
    private val size = array.size

    init {
        require(array.isNotEmpty())
        head = Element(array[0])
        var previous = head
        (1 until array.size).forEach {
            val el = Element(array[it])
            previous.next = el
            previous = el
        }
        previous.next = head
    }

    fun rotate(n: Int): LinkedArray<T> {
        repeat(n) {
            head = head.next
        }
        return this
    }

    fun toList(): List<T> {
        val elements = mutableListOf<T>()
        var ptr = head
        repeat(size) {
            elements.add(ptr.value)
            ptr = ptr.next
        }
        return elements
    }
}

/*
 * Complete the 'rotLeft' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER d
 */
fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    return LinkedArray(a).rotate(d).toList().toTypedArray()
}

fun main(args: Array<String>) {
    val firstMultipleInput = readLine()!!.trimEnd().split(" ")

    val n = firstMultipleInput[0].toInt()
    val d = firstMultipleInput[1].toInt()
    val a = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}
