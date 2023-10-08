package com.harera.leetcode.leetcode204

class Solution {

    fun countPrimes(n: Int): Int {
        val setOfNonPrimes = mutableSetOf<Int>()
        val setOfBases = mutableSetOf<Int>()
        val sqrt = Math.sqrt(n.toDouble()).toInt()

        for (base in sqrt downTo 2) {
            var pow = 1
            for (idx in 1..23) {
                pow *= base
                if (pow < 0 || pow >= n)
                    break
                if (setOfBases.contains(pow))
                    break
                setOfBases.add(pow)
                for (multiplier in 2..2500000) {
                    val res = pow * multiplier
                    if (res < 0 || res >= n)
                        break
                    setOfNonPrimes.add(res)
                }
            }
        }

        var answer = 0
        for (number in 2 until n) {
            if (setOfNonPrimes.contains(number))
                continue
            answer++
        }
        return answer
    }
}

fun main() {
    println(
        Solution().countPrimes(5000000)
    )
}