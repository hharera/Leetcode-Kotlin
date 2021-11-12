package LeetCode951

fun main() {


}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root1 == null || root2 == null)
        return false

    if (root1.`val` != root2.`val`)
        return false

    return search(root1, root2)
}

fun search(root1: TreeNode, root2: TreeNode): Boolean {
    if (root1.left == null && root2.left == null) {
        if (root1.right != root2.right)
            return false
    }

    if (root1.right == null && root2.right == null) {
        if (root1.left != root2.left)
            return false
    }

    if (root1.right == null && root2.left == null) {
        if (root1.left != root2.right)
            return false
    }

    if (root1.left == null && root2.right == null) {
        if (root1.right != root2.left)
            return false
    }
//    #####################

    if (root1.left!!.`val` == root2.left!!.`val`) {
        if (root1.right!!.`val` != root2.right!!.`val`)
            return false
    }

    if (root1.right!!.`val` == root2.right!!.`val`) {
        if (root1.left!!.`val` != root2.left!!.`val`)
            return false
    }

    if (root1.right!!.`val` == root2.left!!.`val`) {
        if (root1.left!!.`val` != root2.right!!.`val`)
            return false
    }

    if (root1.left!!.`val` == root2.right!!.`val`) {
        if (root1.right!!.`val` != root2.left!!.`val`)
            return false
    }

    return true.and(
        if (root1.left != null)
            search(root1.left!!, root2)
        else
            true
    ).and(
        if (root1.right != null)
            search(root1.right!!, root2)
        else
            true
    )
}
