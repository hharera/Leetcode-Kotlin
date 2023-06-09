package com.harera.leetcode.leetcode538

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    private val nodes = hashMapOf<Int, Int>()
    private lateinit var commutativeSum : IntArray

    fun convertBST(root: TreeNode?): TreeNode? {
        getKeys(root)
        commutativeSum = IntArray(nodes.size + 1)
        val keys = nodes.keys.sortedDescending()
        keys.forEachIndexed { index, key ->
            commutativeSum[index + 1] = key + commutativeSum[index]
            nodes.set(key, commutativeSum[index + 1])
        }
        updateKeys(root)
        return root
    }

    private fun updateKeys(root: TreeNode?) {
        if (root == null)
            return

        root.`val` = nodes[root.`val`]!!
        updateKeys(root.right)
        updateKeys(root.left)
    }

    private fun getKeys(root: TreeNode?) {
        if (root == null)
            return
        nodes.set(root.`val`, root.`val`)
        getKeys(root.right)
        getKeys(root.left)
    }
}

fun main() {
    println(Solution().convertBST(TreeNode(5)))
}
