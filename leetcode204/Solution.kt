package com.harera.leetcode.leetcode204

class Solution {

    fun countPrimes(n: Int): Int {
        val setOfNonPrimes = mutableSetOf<Int>()
        val sqrt = Math.sqrt(n.toDouble()).toInt()

        for (base in sqrt downTo 2) {
            var pow = 1
            for (idx in 1..23) {
                pow *= base
                if (pow <= 0 || pow >= n)
                    break
                for (multiplier in 2..2000) {
                    val res = pow * multiplier
                    if (res <= 0 || res >= n)
                        break
                    setOfNonPrimes.add(res)
                }
            }
        }

        return n - setOfNonPrimes.size - 2
    }
}

fun main() {
    println(
        Solution().countPrimes(5000000)
    )
}