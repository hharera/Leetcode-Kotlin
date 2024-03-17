package com.harera.leetcode.leetcode1315

import java.util.*

class Solution {
    fun sumEvenGrandparent(root: TreeNode?): Int {
        return solve(root, Stack())
    }

    private fun solve(root: TreeNode?, queue: Stack<Int>): Int {
        if (root == null) {
            return 0
        }

        var answer = 0
        if (queue.size >= 2 && queue[queue.size - 2] % 2 == 0) {
            answer += root.`val`
        }

        queue.push(root.`val`)

        answer += solve(root.left, queue)
        answer += solve(root.right, queue)

        queue.pop()
        return answer
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


fun main() {
    val solution = Solution()
    //[37,97,18,null,13,18]
    val root = TreeNode(37)
    root.left = TreeNode(97)
    root.right = TreeNode(18)
    root.left?.left = null
    root.left?.right = TreeNode(13)
    root.right?.left = TreeNode(18)
    println(solution.sumEvenGrandparent(root))
}
