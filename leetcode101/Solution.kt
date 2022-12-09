package com.harera.leetcode.leetcode101

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Solution {

    private val levels = mutableListOf<MutableList<Int>>()

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        levels.add(ArrayList())
        traverse(root, 1)
        levels.forEachIndexed { index, mutableList ->
            if (index % 2 == 0)
                mutableList.reverse()
        }
        return levels.drop(1)
    }

    private fun traverse(root: TreeNode?, level: Int) {
        if (root == null)
            return

        if (levels.lastIndex < level) {
            levels.add(arrayListOf(root.`val`))
        } else {
            levels[level].add(root.`val`)
        }
        traverse(root.left, level + 1)
        traverse(root.right, level + 1)
    }
}

fun main() {
    //[3,9,20,null,null,15,7]
    val solution = Solution()
    println(
        solution.zigzagLevelOrder(
            TreeNode(3).apply {
                left = TreeNode(9)
                right = TreeNode(20).apply {
                    left = TreeNode(15)
                    right = TreeNode(7)
                }
            }
        )
    )
}