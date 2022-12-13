package com.harera.leetcode.leetcode122


class Solution {
    fun maxProfit(prices: IntArray): Int {
        var answer = 0
        var min = prices[0]

        for (idx in 1 until prices.lastIndex) {
            if(prices[idx] > min && prices[idx] > prices[idx + 1]) {
                answer += prices[idx] - min
                min = prices[idx + 1]
            } else if(prices[idx] < min) {
                min = prices[idx]
            }
        }
        if (min < prices.last()) {
            answer += prices.last() - min
        }
        return answer
    }
}


fun main() {
    val maxProfit = Solution().maxProfit(intArrayOf(7,6,4,3,1))
    println(maxProfit)
}