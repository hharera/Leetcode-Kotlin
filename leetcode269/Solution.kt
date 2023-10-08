package com.harera.leetcode.leetcode269

import java.util.*
import kotlin.math.min


class Solution {

    private var graph = Array(26) { mutableListOf<Int>() }

    fun alienOrder(words: Array<String>): String {
        graph = Array(26) { mutableListOf<Int>() }
        val charOrder = mutableMapOf<Int, Int>()

        words.forEach {
            it.forEach {
                charOrder[it - 'a'] = 0
            }
        }

        if (words.size == 2 && words[0].startsWith(words[1]))
            return ""

        for (wordIdx in words.lastIndex downTo 1) {
            val nextWord = words[wordIdx]
            val preWord = words[wordIdx - 1]
            val wordLength = min(preWord.length, nextWord.length)

            for (idx in 0 until wordLength) {
                val preChar = preWord[idx] - 'a'
                val nextChar = nextWord[idx] - 'a'

                if (nextWord[idx] != words[wordIdx - 1][idx]) {
                    graph[preChar].add(nextChar)
                    charOrder[nextChar] = charOrder[nextChar]!! + 1
                    break
                }
            }
        }
        val queue: Queue<Int> = LinkedList()
        charOrder.filter { it.value == 0 }.keys.sorted().forEach {
            queue.add(it)
        }

        val result = bfs(queue, charOrder)
        if (result.length != charOrder.size)
            return ""
        return result
    }

    private fun bfs(queue: Queue<Int>, charDependencies: MutableMap<Int, Int>): String {
        var result = ""
        while (queue.isNotEmpty()) {
            for (idx in 1..queue.size) {
                val char = queue.poll()
                result += 'a'.plus(char)

                graph[char].forEach {
                    charDependencies[it] = charDependencies[it]!! - 1
                    if (charDependencies[it] == 0)
                        queue.add(it)
                }
            }
        }
        return result
    }
}

fun main() {
    val solution = Solution()
    println(solution.alienOrder(arrayOf("zy", "zx")))
    println(solution.alienOrder(arrayOf("abc","ab")))
    println(solution.alienOrder(arrayOf("abc", "bcd", "qwert", "ab")))
    println(solution.alienOrder(arrayOf("z", "x")))
    println(solution.alienOrder(arrayOf("z", "x", "z")))
    println(solution.alienOrder(arrayOf("wrt", "wrf", "er", "ett", "rftt")))
    println(
        solution.alienOrder(
            arrayOf(
                "ze",
                "yf",
                "xd",
                "wd",
                "vd",
                "ua",
                "tt",
                "sz",
                "rd",
                "qd",
                "pz",
                "op",
                "nw",
                "mt",
                "ln",
                "ko",
                "jm",
                "il",
                "ho",
                "gk",
                "fa",
                "ed",
                "dg",
                "ct",
                "bb",
                "ba"
            )
        )
    )
}