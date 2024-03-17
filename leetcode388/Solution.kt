package com.harera.leetcode.leetcode388

import kotlin.math.max

class Solution {
    fun lengthLongestPath(input: String): Int {
        if (input.contains('.').not())
            return 0

        return solve(level = 1, input)
    }

    private fun solve(level: Int, input: String): Int {
        if (input.isBlank())
            return 0

        val length = input.split("\n" + "\t".repeat(level - 1)).maxOf {
            it.length
        }
        var answer = length

        val splitter = "\n" + "\t".repeat(level) + "(?!\t)"
        var splited = input.split(splitter.toRegex())

        for (idx in 1..splited.lastIndex) {
            val solve = solve(level + 1, splited[idx])
            answer = max(answer, length + 1 + solve)
        }
        return answer
    }
}

fun main() {
    val solution = Solution()
    println(solution.lengthLongestPath("file1.txt\\nfile2.txt\\nlongfile.txt"))
    println(solution.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"))
}