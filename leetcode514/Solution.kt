package com.harera.leetcode.leetcode514

import kotlin.math.abs

class Solution {
    fun findRotateSteps(ring: String, key: String): Int {
        val ringStr = ring
        var ringIdx = 0

        var answer = 0
        for (char in key.toCharArray()) {
            if (char == ringStr[ringIdx]) {
                answer += 1
                continue
            }

            var nextIdx = (ringIdx + 1) % ring.length
            var clockwiseLength = Int.MAX_VALUE
            var closestIdx = -1
            while (nextIdx != ringIdx) {
                if (ringStr[nextIdx] == char) {
                    if (abs(nextIdx - ringIdx) < clockwiseLength) {
                        clockwiseLength = abs(nextIdx - ringIdx)
                        closestIdx = nextIdx
                    }
                }
                nextIdx = (nextIdx + 1) % ring.length
            }

            ringIdx = (ringIdx + clockwiseLength) % ring.length

            if (clockwiseLength > (ring.length - 1) / 2)
                clockwiseLength = ring.length - clockwiseLength
            answer += (clockwiseLength) + 1
        }

        return answer
    }
}

fun main() {
    val solution = Solution()
    println(solution.findRotateSteps("edcba", "abcde"))
}
