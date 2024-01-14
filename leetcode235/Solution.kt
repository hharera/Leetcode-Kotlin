package com.harera.leetcode.leetcode235

import java.util.*

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val pStack = getStack(root!!, p!!)
        val qStack = getStack(root, q!!)

        while (pStack.isNotEmpty() && qStack.isNotEmpty()) {
            if (pStack.peek().`val` == qStack.peek().`val`)
                return pStack.peek()
            if (pStack.size > qStack.size)
                pStack.pop()
            else
                qStack.pop()
        }

        return null
    }

    private fun getStack(
        root: TreeNode, target: TreeNode
    ): Stack<TreeNode> {
        var _root: TreeNode? = root
        val stack = Stack<TreeNode>()
        while (_root != null) {
            if (_root.`val` == target.`val`) {
                stack.add(_root)
                break
            } else if (_root.`val` < target.`val`) {
                stack.add(_root)
                _root = _root.right
            } else {
                stack.add(_root)
                _root = _root.left
            }
        }
        return stack
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val solution = Solution()
//    6,2,8,0,4,7,9,null,null,3,5
    val root = TreeNode(6)
    root.left = TreeNode(2)
    root.right = TreeNode(8)
    root.left!!.left = TreeNode(0)
    root.left!!.right = TreeNode(4)
    root.right!!.left = TreeNode(7)
    root.right!!.right = TreeNode(9)
    root.left!!.right!!.left = TreeNode(3)
    root.left!!.right!!.right = TreeNode(5)
    println(solution.lowestCommonAncestor(root, root.left, root.right)?.`val`)
}