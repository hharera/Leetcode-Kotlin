package com.harera.leetcode.leetcode791


class Solution {
    fun customSortString(order: String, s: String): String {
        val chars = HashMap<Char, Int>()
        var remaining = ""
        s.forEach {
            chars[it] = chars.getOrDefault(it, 0) + 1
            if (order.contains(it).not())
                remaining += it
        }

        var result = ""
        order.forEach {
            result += "$it".repeat(chars.getOrDefault(it, 0))
        }
        return result + remaining
    }

    fun customSortString_v1(order: String, s: String): String {
        val toChar = HashMap<Int, Char>()
        val toInt = HashMap<Char, Int>()

        order.forEachIndexed { index, c ->
            toChar[index] = c
            toInt[c] = index
        }
        for (char in 0..25) {
            if (!toInt.containsKey('a' + char)) {
                toChar[toChar.size] = 'a' + char
                toInt['a' + char] = toInt.size
            }
        }
        return s.map {
            toInt[it]!!
        }.sortedBy {
            it
        }.map {
            toChar[it]!!
        }.joinToString("")
    }
}

fun main() {
    val solution = Solution()
    println(solution.customSortString("cba", "abcd"))
}