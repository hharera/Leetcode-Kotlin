package LeetCode426

internal class Node {
    var `val` = 0
    var left: Node? = null
    var right: Node? = null

    constructor() {}
    constructor(_val: Int, _left: Node?, _right: Node?) {
        `val` = _val
        left = _left
        right = _right
    }
}

internal class Solution {
    private var head: Node? = null
    fun treeToDoublyList(root: Node?): Node? {
        if (null == root) return null
        val last = dfs(root, null)
        last!!.right = head
        head!!.left = last
        return head
    }

    private fun dfs(node: Node?, prev: Node?): Node? {
        var prev = prev
        if (null == node) return null
        val leftRet = dfs(node.left, prev)
        if (null != leftRet) {
            prev = leftRet
        }
        val cur = Node(node.`val`, null, null)
        if (null != prev) {
            cur.left = prev
            prev.right = cur
        }
        if (null == head) {
            head = cur
        }
        val rightRet = dfs(node.right, cur)
        return rightRet ?: cur
    }
}