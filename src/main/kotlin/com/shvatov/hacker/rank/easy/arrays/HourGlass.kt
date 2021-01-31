import java.util.*

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    TODO("Not implemented yet!")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array(6) { Array(6) { 0 } }
    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)
    println(result)
}
