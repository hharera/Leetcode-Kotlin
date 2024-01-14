package com.harera.leetcode.leetcode1320

import kotlin.math.abs

class Solution {

    private val charPos = mapOf(
        'A' to Pair(0, 0),
        'B' to Pair(0, 1),
        'C' to Pair(0, 2),
        'D' to Pair(0, 3),
        'E' to Pair(0, 4),
        'F' to Pair(0, 5),
        'G' to Pair(1, 0),
        'H' to Pair(1, 1),
        'I' to Pair(1, 2),
        'J' to Pair(1, 3),
        'K' to Pair(1, 4),
        'L' to Pair(1, 5),
        'M' to Pair(2, 0),
        'N' to Pair(2, 1),
        'O' to Pair(2, 2),
        'P' to Pair(2, 3),
        'Q' to Pair(2, 4),
        'R' to Pair(2, 5),
        'S' to Pair(3, 0),
        'T' to Pair(3, 1),
        'U' to Pair(3, 2),
        'V' to Pair(3, 3),
        'W' to Pair(3, 4),
        'X' to Pair(3, 5),
        'Y' to Pair(4, 0),
        'Z' to Pair(4, 1)
    )

    private val dp = Array(300) { Array(26) { Array(26) { -1 } } }

    fun minimumDistance(word: String): Int {
        return calculate(0, word[0]!!, word[0]!!, word)
    }

    fun calculate(idx: Int, leftChar: Char?, rightChar: Char?, word: String): Int {
        if (idx > word.lastIndex)
            return 0

//        if (dp[idx][leftChar - 'A'][rightChar - 'A'] != -1)
//            return dp[idx][leftChar - 'A'][rightChar - 'A']

        var result = 0
        val leftPos = charPos[leftChar]!!
        val rightPos = charPos[rightChar]!!
        val curPos = charPos[word[idx]]!!
        val leftDis = distance(leftPos, curPos)
        val rightDis = distance(rightPos, curPos)

        result = minOf(
            rightDis + calculate(idx + 1, leftChar, word[idx], word),
            leftDis + calculate(idx + 1, word[idx], rightChar, word)
        )
        return result.also {
//            dp[idx][leftChar - 'A'][rightChar - 'A'] = it
        }
    }

    private fun distance(leftFinger: Pair<Int, Int>, pair: Pair<Int, Int>): Int {
        return abs(leftFinger.first - pair.first) + abs(leftFinger.second - pair.second)
    }
}

fun main() {
    val solution = Solution()
    println(solution.minimumDistance("CAKE"))
}