package com.harera.leetcode.leetcode116

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}


class Solution {

    private val nodes = Array<Node?>(10000) { null }
    fun connect(root: Node?): Node? {
        traverse(root, 1)
        for (i in 2 until nodes.size) {
            if (nodes[i] != null) {
                val node = nodes[i]
                if (i + 1 < nodes.size && nodes[i + 1] != null) {
                    node?.next = nodes[i + 1]
                }
            }
        }
        return root
    }

    private fun traverse(root: Node?, idx: Int) {
        if (root == null)
            return

        nodes[idx] = root
        traverse(root.left, idx * 2 + 1)
        traverse(root.right, idx * 2 + 2)
    }
}

fun main() {
    //[1,2,3,4,5,6,7]
    val solution = Solution()
    solution.connect(
        Node(1).apply {
            left = Node(2).apply {
                left = Node(4)
                right = Node(5)
            }
            right = Node(3).apply {
                left = Node(6)
                right = Node(7)
            }
        }
    ).also {
        println(it)
    }
}