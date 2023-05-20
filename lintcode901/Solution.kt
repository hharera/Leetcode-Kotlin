package com.harera.leetcode.lintcode901

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    private var target = 0.0
    private val priorityQueue = PriorityQueue<Int> { a, b ->
        val aDiff = Math.abs(a - target)
        val bDiff = Math.abs(b - target)
        if (aDiff == bDiff) {
            a - b
        } else {
            aDiff.toInt() - bDiff.toInt()
        }
    }

    fun closestKValues(root: TreeNode?, target: Double, k: Int): List<Int> {
        this.target = target
        dfs(root)
        val result = mutableListOf<Int>()
        for (i in 0 until k) {
            result.add(priorityQueue.poll())
        }
        return result
    }

    private fun dfs(root: TreeNode?) {
        if (root == null)
            return

        dfs(root.left)
        priorityQueue.add(root.`val`)
        dfs(root.right)
    }
}

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(1)
    root.right = TreeNode(4)
    root.left!!.right = TreeNode(2)

    val solution = Solution()
    println(solution.closestKValues(root, 0.275000, 2))
}
