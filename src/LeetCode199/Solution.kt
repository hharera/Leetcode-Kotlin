package LeetCode199

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    println(rightSideView(
        TreeNode(1).apply {
            left = TreeNode(2).apply {
            }
        }
    ).toString())
}

var ti = TreeNode(5)
var v = ti.`val`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun rightSideView(root: TreeNode?, depth: Int, result: ArrayList<Int>) {
    if (root == null) {
        return
    }

    if (depth == result.size) {
        result.add(root.`val`)
    }

    rightSideView(root.right, depth + 1, result)
    rightSideView(root.left, depth + 1, result)
}

fun rightSideView(root: TreeNode?): List<Int> {
    val result = arrayListOf<Int>()
    rightSideView(root, 0, result)
    return result
}
