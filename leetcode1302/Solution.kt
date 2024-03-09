package com.harera.leetcode.leetcode1302


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    private val levelSum = HashMap<Int, Int>()
    fun deepestLeavesSum(root: TreeNode?): Int {
        dfs(root, 0)
        return levelSum[levelSum.keys.maxOrNull()!!]!!
    }

    private fun dfs(root: TreeNode?, level: Int) {
        if (root == null) {
            return
        }
        levelSum[level] = levelSum.getOrDefault(level, 0) + root.`val`
        dfs(root.left, level + 1)
        dfs(root.right, level + 1)
    }
}

// 6,7,8,2,7,1,3,9,null,1,4,null,null,null,5
// 0,1,2,3,4,5,6,7,8   ,9,10,  11,12 ,13  ,14

// 1,2,3,4,5,null,6,7,null,null,null,null,8
// 0,1,2,3,4,5   ,6,7,  8,   9,  10,  11,  12

