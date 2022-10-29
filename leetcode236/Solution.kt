package LeetCode236

import java.util.*

fun main() {


}

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (searchConnectivity(p!!, q!!) != null)
            return p

        if (searchConnectivity(q, p) != null)
            return q

        return searchChild(root!!, q, p)
    }

    private fun searchChild(first: TreeNode, q: TreeNode, p: TreeNode): TreeNode? {
        val list = LinkedList<TreeNode>()
        list.add(first)

        while (list.isNotEmpty()) {
            val cur = list.poll()

            if (cur.left != null) {
                if (cur.left!!.`val` == p.`val` || cur.left!!.`val` == q.`val`)
                    return cur
                list.add(cur.left!!)
            }

            if (cur.right != null) {
                if (cur.right!!.`val` == p.`val` || cur.right!!.`val` == q.`val`)
                    return cur

                list.add(cur.right!!)
            }
        }

        return null
    }

    private fun searchConnectivity(q: TreeNode, p: TreeNode): TreeNode? {
        if (q.left == null && q.right == null) {
            return null
        }

        var ans: TreeNode? = null

        if (q.left != null) {
            if (q.left!!.`val` == p.`val`)
                return q

            ans = searchConnectivity(q.left!!, p) ?: ans
        }

        if (q.right != null) {
            if (q.right!!.`val` == p.`val`)
                return q

            ans = searchConnectivity(q.right!!, p) ?: ans
        }


        return ans
    }
}
