package com.harera.leetcode.leetcode236

import java.util.*

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (p == null || q == null)
            return null

        var pAncestors = getAncestors(q, p.`val`, emptyList()).sortedBy {
            it.`val`
        }.let {
            LinkedList(it)
        }

        if (pAncestors.isNotEmpty())
            return pAncestors.peek()

        var qAncestors = getAncestors(p, q.`val`, emptyList()).sortedBy {
            it.`val`
        }.let {
            LinkedList(it)
        }

        if (qAncestors.isNotEmpty())
            return qAncestors.peek()

        pAncestors = getAncestors(root, p.`val`, emptyList()).sortedBy {
            it.`val`
        }.let {
            LinkedList(it)
        }
        qAncestors = getAncestors(root, q.`val`, emptyList()).sortedBy {
            it.`val`
        }.let {
            LinkedList(it)
        }

        while (qAncestors.isNotEmpty() && pAncestors.isNotEmpty()) {
            if (qAncestors.peek().`val` < pAncestors.peek().`val`) {
                qAncestors.poll()
                continue
            }
            if (qAncestors.peek().`val` > pAncestors.peek().`val`) {
                pAncestors.poll()
                continue
            }
            return qAncestors.poll()
        }
        return null
    }

    private fun getAncestors(root: TreeNode?, child: Int, ancestors: List<TreeNode>): List<TreeNode> {
        if (root == null) {
            return emptyList()
        }

        if (root.`val` == child)
            return ancestors.apply {
                plus(root)
            }


        val left = getAncestors(root.left, child, ancestors.plus(root))
        if (left.isNotEmpty())
            return left

        val right = getAncestors(root.right, child, ancestors.plus(root))
        if (right.isNotEmpty())
            return right

        return emptyList()
    }

}

fun main() {
    // [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
    val solution = Solution()
    solution.lowestCommonAncestor(
        TreeNode(3).apply {
            left = TreeNode(5).apply {
                left = TreeNode(6)
                right = TreeNode(2).apply {
                    left = TreeNode(7)
                    right = TreeNode(4)
                }
            }
            right = TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(8)
            }
        },
        TreeNode(5),
        TreeNode(4)
    ).let {
        println(it)
    }
}
