package com.shvatov.hacker.rank.yandex

fun task1(input: String): String {
    var counter: Int = 1
    var previous: Char = input.firstOrNull() ?: return ""
    val builder = StringBuilder()
    (1 until input.length).forEach { index ->
        val current = input[index]
        if (current == previous) {
            counter++
        } else {
            builder.append("$previous${if (counter > 1) counter else ""}")
            previous = current
            counter = 1
        }
    }

    if (counter >= 1) {
        builder.append("$previous${if (counter > 1) counter else ""}")
    }

    return builder.toString()
}

fun task2(input: Array<Int>, k: Int): List<Int> {
    if (k == 0) return emptyList()

    if (k < 0) {
        error("")
    }

    val counterByElement = input.groupBy { it }
        .mapValues { (_, v) -> v.size }
        .toList()

    if (counterByElement.size < k) {
        error("error!")
    }

    return counterByElement.sortedByDescending { it.second }
        .take(k)
        .map { it.first }
}

class CurrencyEnum private constructor(private val name: String, private val ordinal: Int) {
    init {
        require(name.isNotBlank())
        require(ordinal >= 0)
    }

    companion object {
        private val ACCEPTABLE_ENUM_VALUES = mutableListOf<CurrencyEnum>()

        private fun createNewEnumValue(name: String): CurrencyEnum =
            CurrencyEnum(name, ACCEPTABLE_ENUM_VALUES.size).also {
                ACCEPTABLE_ENUM_VALUES.add(it)
            }

        val RUBBLE: CurrencyEnum = createNewEnumValue("rubble")

        val EURO: CurrencyEnum = createNewEnumValue("euro")

        val DOLLAR: CurrencyEnum = createNewEnumValue("dollar")

        fun getByOrdinal(ordinal: Int): CurrencyEnum =
            ACCEPTABLE_ENUM_VALUES.filter { it.ordinal == ordinal }
                .also { foundEnumValues ->
                    if (foundEnumValues.size != 1) {
                        error("")
                    }
                }.first()

        fun getByName(name: String): CurrencyEnum =
            ACCEPTABLE_ENUM_VALUES.filter { it.name == name }
                .also { foundEnumValues ->
                    if (foundEnumValues.size != 1) {
                        error("")
                    }
                }.first()
    }
}

fun task6(input: Array<Int>): Int {
    var firstMinimumValue = Int.MAX_VALUE
    var secondMinimumValue = Int.MAX_VALUE

    input.forEach { element ->
        if (element <= firstMinimumValue) {
            if (firstMinimumValue <= secondMinimumValue) {
                secondMinimumValue = firstMinimumValue
            }

            firstMinimumValue = element
        } else if (element <= secondMinimumValue) {
            secondMinimumValue = element
        }
    }

    return firstMinimumValue * secondMinimumValue
}

fun task7(input: Array<Int>, k: Int): Pair<Int, Int>? {
    input.ifEmpty { return null }
    var first = 0
    var last = input.size - 1
    while (first != last && (input[first] + input[last] != k)) {
        val sum = input[first] + input[last]
        if (sum < k) {
            first += 1
        } else {
            last -= 1
        }
    }
    return if (first == last) {
        return null
    } else {
        input[first] to input[last]
    }
}

fun main() {
    println(task1("TT"))
    println(task2(arrayOf(1, 2, 2, 1, 1, 3, 4, 5, 6, 7, 8, 9), 4))

    val dollar = CurrencyEnum.DOLLAR
    val euro = CurrencyEnum.getByName("euro")
    val rubble = CurrencyEnum.getByOrdinal(0)

    val iter = EvenIteratorStream(listOf(1, 2, 2, 1, 1, 3, 4, 5, 6, 7, 8, 9))
    while (iter.hasNext()) {
        println(iter.hasNext())
        println(iter.next())
    }

    println(task6(arrayOf(9, 4, 2, 5, 3)))

    println(task7(arrayOf(-2, -1, 1, 2), 0))
}