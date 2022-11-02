package LeetCode1379

internal class Solution {
    fun getTargetCopy(original: TreeNode?, cloned: TreeNode?, target: TreeNode): TreeNode? {
        var ans: TreeNode? = null
        if (original == null) {
            return null
        }
        if (target.`val` == original.`val`) {
            return cloned
        }
        ans = ans ?: getTargetCopy(original.left, cloned!!.left, target)
        ans = ans ?: getTargetCopy(original.right, cloned!!.right, target)
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
        }
    }
}

internal class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}