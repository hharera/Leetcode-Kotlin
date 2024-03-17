package com.harera.leetcode.leetcode375

import kotlin.math.max

class Solution {

    fun getMoneyAmount(n: Int): Int {
        var answer = Int.MIN_VALUE
        for (number in 1..n) {
            var mid = (1 + n) * 3 / 4 - 1
            var paid = 0
            while (mid != number) {
                paid += mid
                if (number > mid) {
                    mid += ((number - mid - 1) / 2)
                } else {
                    mid -= (mid - number + 1) / 2
                }
            }
            answer = max(answer, paid)
        }
        return answer
    }
}

fun main() {
    val solution = Solution()
    val n = 10
    println(solution.getMoneyAmount(n))
}