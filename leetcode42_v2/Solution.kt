package com.harera.leetcode.leetcode42_v2

import kotlin.math.min

class Solution {

    fun trap(height: IntArray): Int {
        var left = 0
        var right = 1
        var answer = 0

        while (left < height.size && right < height.size) {
            if (height[left] > 0) {
                if (height[right] < height[left]) {
                    left--
                } else if (height[right] >= height[left]) {
                    answer += calculate(height, left, right)
                    left = right - 1
                }
            }
            left++
            right++
        }
        if (right < height.size && height[right] >= height[left]) {
            answer += calculate(height, left, right)
        }
        return answer
    }

    private fun calculate(height: IntArray, i: Int, j: Int): Int {
        var answer = 0
        val min = min(height[i], height[j])
        for (idx in i + 1 until j)
            answer += min - height[idx]
        return answer
    }
}

fun main() {
    val solution = Solution()
    println(solution.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
}
