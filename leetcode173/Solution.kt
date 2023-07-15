package com.harera.leetcode.leetcode173

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BSTIterator(root: TreeNode?) {
    lateinit var queue: LinkedList<TreeNode>

    init {
        queue = getNodes(root).toCollection(LinkedList())
    }

    private fun getNodes(root: TreeNode?): List<TreeNode> {
        if (root == null)
            return emptyList()

        return getNodes(root.left).plus(root).plus(getNodes(root.right))
    }

    fun next(): Int {
        return queue.poll().`val`
    }

    fun hasNext(): Boolean {
        return queue.isNotEmpty()
    }
}
