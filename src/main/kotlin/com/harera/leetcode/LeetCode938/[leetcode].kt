package LeetCode938

internal class Solution {
    fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
        if (root == null) {
            return 0
        }
        if (vis[root.`val`]!!) {
            return 0
        }
        var ans = 0
        if (vis[root.`val`] == null) {
            vis[root.`val`] = true
            if (root.`val` <= R && root.`val` >= L) {
                ans += root.`val`
            }
        }
        ans += rangeSumBST(root.left, L, R)
        ans += rangeSumBST(root.right, L, R)
        return ans
    }

    companion object {
        var vis = arrayOfNulls<Boolean>(10005)
        @JvmStatic
        fun main(args: Array<String>) {
            if (vis[500] == null) {
                println("right")
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