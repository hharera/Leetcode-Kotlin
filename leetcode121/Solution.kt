package com.harera.leetcode.leetcode121

import kotlin.math.max

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var answer = 0
        var min = prices[0]
        var minIdx = 0

        prices.forEachIndexed { index, value ->
            if (value < min) {
                min = value
                minIdx = minIdx
            } else {
                answer = max(answer, value - min)
            }
        }

        return answer
    }
}


fun main() {

}