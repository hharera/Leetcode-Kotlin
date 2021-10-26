package LeetCode543

import kotlin.math.max

fun main() {
    println(diameterOfBinaryTree(
        TreeNode(
            1
        ).apply {
            right = TreeNode(2).apply {
                right = TreeNode(5).apply {
                }
            }
        }
    ))
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null)
        return 0

    var ans = 0

    if (root.left != null)
        ans += solve(root.left, 0) - 1

    if (root.right != null)
        ans += solve(root.right, 0) - 1

    return ans + 1
}

fun solve(root: TreeNode?, depth: Int): Int {
    if (root == null)
        return 0

    var ans = Int.MIN_VALUE

    if (root.left != null)
        ans = max(ans, solve(root.left!!, depth + 1) + 1)

    if (root.right != null)
        ans = max(ans, solve(root.right!!, depth + 1) + 1)

    return ans
}
