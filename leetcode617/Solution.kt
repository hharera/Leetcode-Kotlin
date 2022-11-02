package LeetCode617

internal class Solution {
    lateinit var T1: Array<TreeNode?>
    lateinit var T2: Array<TreeNode?>
    lateinit var newTtree: Array<TreeNode?>
    fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
        newTtree = arrayOfNulls(10000)
        T2 = newTtree
        T1 = T2
        fillTree(T1, t1, 0)
        fillTree(T2, t2, 0)
        fillAnswer()
        val t: TreeNode? = null
        return fillNewTree(t, 0)
    }

    private fun fillTree(T1: Array<TreeNode?>, t1: TreeNode?, i: Int) {
        if (t1 == null) {
            T1[i] = null
            return
        }
        T1[i] = t1
        fillTree(T1, t1.left, i * 2 + 1)
        fillTree(T1, t1.right, i * 2 + 2)
    }

    private fun fillNewTree(t: TreeNode?, i: Int): TreeNode? {
        var t = t
        if (newTtree[i] == null) {
            return null
        }
        t = newTtree[i]
        fillNewTree(t!!.left, i * 2 + 1)
        fillNewTree(t.right, i * 2 + 2)
        return t
    }

    private fun fillAnswer() {
        for (i in T1.indices) {
            if (T1[i] != null && T2[i] != null) {
                newTtree[i] = TreeNode(T2[i]!!.`val` + T1[i]!!.`val`)
            } else if (T2[i] == null) {
                newTtree[i] = T1[i]
            } else if (T1[i] == null) {
                newTtree[i] = T2[i]
            } else {
                newTtree[i] = null
            }
        }
    }
}

internal class TreeNode {
    var `val` = 0
    var left: TreeNode? = null
    var right: TreeNode? = null

    constructor() {}
    constructor(`val`: Int) {
        this.`val` = `val`
    }

    constructor(`val`: Int, left: TreeNode?, right: TreeNode?) {
        this.`val` = `val`
        this.left = left
        this.right = right
    }
}