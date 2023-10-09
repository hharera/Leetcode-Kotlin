package com.harera.leetcode.leetcode401

import java.lang.Math.pow
import java.util.*

class Solution {

    private val combinations = mutableListOf<BitSet>()

    fun readBinaryWatch(turnedOn: Int): List<String> {
        combinations(0, turnedOn, leds = BitSet(10))

        var solutions = mutableListOf<String>()
        for (it in combinations) {

            var hour = 0
            var minutes = 0
            for (idx in 0..9) {
                if (idx < 4 && it[idx])
                    hour += pow(idx.toDouble(), 2.toDouble()).toInt()

                if (hour > 3 && it[idx])
                    minutes += pow((idx - 4).toDouble(), 2.toDouble()).toInt()

            }
            if (hour > 11 || minutes > 59)
                continue

            solutions.add("$hour:$minutes")
        }
        return solutions
    }

    fun combinations(idx: Int, rest: Int, leds: BitSet) {
        if (rest == 0) {
            combinations.add(leds)
            return
        }
        if (idx > 9)
            return

        val new = BitSet(leds.size()).apply {
            or(leds)
            flip(idx)
        }
        combinations(idx + 1, rest - 1, new)
        combinations(idx + 1, rest, leds)
    }
}


fun main() {
    val solution = Solution()
    println(solution.readBinaryWatch(1))

}