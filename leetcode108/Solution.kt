package com.harera.leetcode.leetcode108


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Solution {

    var head: TreeNode? = null

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        head = TreeNode(nums[nums.lastIndex / 2])
        traverse(nums, head, nums.lastIndex / 2, 0, nums.lastIndex)
        return head
    }

    private fun traverse(nums: IntArray, node: TreeNode?, cur: Int, min: Int, max: Int) {
        if (node == null)
            return

        if (min == max)
            return

        var left = (min + cur) / 2
        var right = (cur + max) / 2

        if (cur != left) {
            node.left = TreeNode(nums[left])
            traverse(nums, node.left, left, min, cur - 1)
        }
        if (cur != right) {
            node.right = TreeNode(nums[right])
            traverse(nums, node.right, right, cur + 1, right)
        }
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.sortedArrayToBST(
            intArrayOf(-10, -3, 0, 5, 9)
        ).let {
            println(it?.`val`)
        }
    )
}