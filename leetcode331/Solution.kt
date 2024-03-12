package com.harera.leetcode.leetcode331

class Solution {
    fun isValidSerialization(preorder: String): Boolean {
        val solution = solve(preorder.split(",").toMutableList(), 0)
        if (solution == -1) {
            return false
        }
        return solution == preorder.split(",").size
    }

    private fun solve(nodes: MutableList<String>, idx: Int): Int {
        if (idx > nodes.lastIndex) {
            return -1
        }
        if (nodes[idx] == "#") {
            return 1
        }
        val leftNodes = solve(nodes, idx + 1)
        if (leftNodes == -1) {
            return -1
        }
        val rightNodes = solve(nodes, idx + leftNodes + 1)
        if (rightNodes == -1) {
            return -1
        }
        return leftNodes + rightNodes + 1
    }
}

fun main() {
    val solution = Solution()
    println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"))
    println(solution.isValidSerialization("1,#"))
    println(solution.isValidSerialization("9,#,#,1"))
    println(solution.isValidSerialization("#"))
    println(solution.isValidSerialization("#,#"))
    println(solution.isValidSerialization("1,#,#,#,#"))
    println(solution.isValidSerialization("1,#,#,#,#,#"))
    println(solution.isValidSerialization("1,#,#,#,#,#,#"))
    println(solution.isValidSerialization("1,#,#,#,#,#,#,#"))
    println(solution.isValidSerialization("1,#,#,#,#,#,#,#,#"))
    println(solution.isValidSerialization("1,#,#,#,#,#,#,#,#,#"))
    println(solution.isValidSerialization("1"))
}