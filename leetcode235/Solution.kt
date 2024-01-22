package com.harera.leetcode.leetcode235

import java.util.*

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val pStack = getStack(root!!, 0, p!!, Stack<Pair<TreeNode, Int>>())
        val qStack = getStack(root, 0, q!!, Stack<Pair<TreeNode, Int>>())

        val pLevel = pStack.peek().second
        val qLevel = qStack.peek().second
        if (pLevel > qLevel && checkParent(node = pStack.peek().first, parent = qStack.peek().first)) {
            return qStack.peek().first
        } else if (pLevel < qLevel && checkParent(node = qStack.peek().first, parent = pStack.peek().first)) {
            return pStack.peek().first
        }

        val pLevels = pStack.filter {
            it.second < pLevel && it.second < qLevel
        }.sortedByDescending {
            it.second
        }

        val qLevels = qStack.filter {
            it.second < pLevel && it.second < qLevel
        }.sortedByDescending {
            it.second
        }

        var i = 0
        var j = 0
        while (i < pLevels.size && j < qLevels.size) {
            if (pLevels[i].second == qLevels[j].second)
                if(checkParent(node = qStack.peek().first, parent = pLevels[i].first))
                    return pLevels[i].first
                else {
                    j++;
                    i++
                }
            else if (pLevels[i].second > qLevels[j].second)
                i++
            else
                j++
        }
        return null
    }

    private fun checkParent(node: TreeNode, parent: TreeNode?): Boolean {
        if (parent == null)
            return false
        if (node.`val` == parent.`val`)
            return true
        return checkParent(node, parent.left) || checkParent(node, parent.right)
    }

    private fun getStack(
        root: TreeNode, level: Int, p: TreeNode, stack: Stack<Pair<TreeNode, Int>>
    ): Stack<Pair<TreeNode, Int>> {
        if (root.`val` == p.`val`) return stack.also { it.add(Pair(root, level)) }

        var _stack = stack
        _stack.add(Pair(root, level))
        root.left?.let {
            _stack = getStack(it, level + 1, p, stack)
            if (_stack.peek().first.`val` == p.`val`) return stack
        }

        root.right?.let {
            _stack = getStack(it, level + 1, p, stack)
            if (_stack.peek().first.`val` == p.`val`) return stack
        }
        return _stack
    }
}

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    val solution = Solution()
//    println(
//        solution.lowestCommonAncestor(
//            TreeNode(3).apply {
//                left = TreeNode(5).apply {
//                    left = TreeNode(6)
//                    right = TreeNode(2).apply {
//                        left = TreeNode(7)
//                        right = TreeNode(4)
//                    }
//                }
//                right = TreeNode(1).apply {
//                    left = TreeNode(0)
//                    right = TreeNode(8)
//                }
//            }, TreeNode(5), TreeNode(1)
//        )
//    )

//    [6,2,8,0,4,7,9,null,null,3,5]
    println(
        solution.lowestCommonAncestor(
            TreeNode(6).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(0)
                    right = TreeNode(4).apply {
                        left = TreeNode(3)
                        right = TreeNode(5)
                    }
                }
                right = TreeNode(8).apply {
                    left = TreeNode(7)
                    right = TreeNode(9)
                }
            }, TreeNode(3), TreeNode(5)
        )?.`val`
    )
}