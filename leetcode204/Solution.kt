package com.harera.leetcode.leetcode204

class Solution {

    fun countPrimes(n: Int): Int {
        if (n < 2)
            return 0
        val prime = BooleanArray(n + 1) { true }
        prime[0] = false
        prime[1] = false
        var i = 2
        while (i * i <= n) {
            if (prime[i].not()) {
                i++
                continue
            }
            var j = i * i
            while (j <= n) {
                prime[j] = false
                j += i
            }
            i++
        }
        var answer = 0
        for (i in 2 until n) {
            if (prime[i]) {
                answer++
            }
        }
        return answer
    }
}

fun main() {
    println(
        Solution().countPrimes(5000000)
    )
}