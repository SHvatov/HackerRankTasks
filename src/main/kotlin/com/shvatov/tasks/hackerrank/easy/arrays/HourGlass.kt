import java.util.*

private const val MAX_ARR_DIM = 6

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    var maxSum = Int.MIN_VALUE
    (0..(MAX_ARR_DIM - 3)).forEach { i ->
        (0..(MAX_ARR_DIM - 3)).forEach { j ->
            val sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +
                    arr[i + 1][j + 1] +
                    arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]
            if (sum > maxSum) {
                maxSum = sum
            }
        }
    }
    return maxSum
}

fun main() {
    val scan = Scanner(System.`in`)

    val arr = Array(MAX_ARR_DIM) { Array(MAX_ARR_DIM) { 0 } }
    for (i in 0 until MAX_ARR_DIM) {
        arr[i] = scan.nextLine()
            .split(" ")
            .map { it.trim().toInt() }
            .toTypedArray()
    }

    val result = hourglassSum(arr)
    println(result)
}
