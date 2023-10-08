//package com.harera.leetcode.leetcode1320
//
//import kotlin.math.abs
//import kotlin.math.min
//
//class Solution {
//
//    private val charPos = mapOf(
//        'A' to Pair(0, 0),
//        'B' to Pair(0, 1),
//        'C' to Pair(0, 2),
//        'D' to Pair(0, 3),
//        'E' to Pair(0, 4),
//        'F' to Pair(0, 5),
//        'G' to Pair(1, 0),
//        'H' to Pair(1, 1),
//        'I' to Pair(1, 2),
//        'J' to Pair(1, 3),
//        'K' to Pair(1, 4),
//        'L' to Pair(1, 5),
//        'M' to Pair(2, 0),
//        'N' to Pair(2, 1),
//        'O' to Pair(2, 2),
//        'P' to Pair(2, 3),
//        'Q' to Pair(2, 4),
//        'R' to Pair(2, 5),
//        'S' to Pair(3, 0),
//        'T' to Pair(3, 1),
//        'U' to Pair(3, 2),
//        'V' to Pair(3, 3),
//        'W' to Pair(3, 4),
//        'X' to Pair(3, 5),
//        'Y' to Pair(4, 0),
//        'Z' to Pair(4, 1)
//    )
//
//    fun minimumDistance(word: String): Int {
//        var result = Int.MAX_VALUE
//        for (idx in 0..25) {
//            for (idx_ in 0..25) {
//                if (idx == idx_)
//                    continue
//                result = min(result, calculate(0, charPos['A' + idx]!!, charPos['A' + idx_]!!, word))
//            }
//        }
//        return result
//    }
//
//    fun calculate(idx: Int, left: Int, right: Int, word: String): Int {
//        if (idx > word.lastIndex)
//            return 0
//
//        var result = 0
//        val curPos = charPos[word[idx]]!!
//        val leftDis = distance(left, curPos)
//        val rightDis = distance(right, curPos)
//
//        if (leftDis < rightDis) {
//            result = leftDis + calculate(idx + 1, curPos, right, word)
//        } else {
//            result = rightDis + calculate(idx + 1, left, curPos, word)
//        }
//        return result
//    }
//
//    private fun distance(leftFinger: Pair<Int, Int>, pair: Pair<Int, Int>): Int {
//        return abs(leftFinger.first - pair.first) + abs(leftFinger.second - pair.second)
//    }
//}
//
//fun main() {
//    val solution = Solution()
//    println(solution.minimumDistance("OPVUWZLCKTDPSUKGHAXIDWHLZFKNBDZEWHBSURTVCADUGTSDMCLDBTAGFWDPGXZBVARNTDICHCUJLNFBQOBTDWMGILXPSFWVGYBZVFFKQIDTOVFAPVNSQJULMVIERWAOXCKXBRI"))
//}