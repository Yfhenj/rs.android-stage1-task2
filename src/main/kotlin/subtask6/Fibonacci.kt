package subtask6

class Fibonacci {

    // TODO: Complete the following function
    fun productFibonacciSequenceFor(number: Int): IntArray {
        var n = 0
        while (F(n) * F(n + 1) < number) n++
        val resultFirst = F(n)
        val resultSecond = F(n + 1)
        return intArrayOf(resultFirst, resultSecond, if(resultFirst * resultSecond == number) 1 else 0)
    }

    fun F(n: Int): Int = when (n) {
        0 -> 0
        1 -> 1
        else -> F(n - 2) + F(n - 1)
    }
}
