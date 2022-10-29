package LeetCode124

import LeetCode173.TreeNode
import kotlin.math.max

fun main() {
    println(
        maxPathSum(
            TreeNode(-10).apply {
                left = TreeNode(9).apply {

                }

                right = TreeNode(20).apply {
                    left = TreeNode(7).apply {

                    }

                    right = TreeNode(15).apply {

                    }
                }
            }
        ).toString())
}

var max = Int.MIN_VALUE
fun maxPathSum(root: TreeNode?): Int {
    return solve(root, 0)
}

fun solve(root: TreeNode?, sum: Int): Int {
    if (root == null)
        return sum

    val left = max(
        solve(root.left, sum),
        solve(root.left, sum + root.`val`)
    )

    solve(root.right, sum)
    solve(root.right, sum + root.`val` + left)

    return sum
}
