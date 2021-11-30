package LeetCode951

fun main() {


}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun flipEquiv(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root1 == null && root2 == null)
        return true

    if ((root1 == null && root2 != null) || (root2 == null && root1 != null))
        return false

    if (root1!!.`val` != root2!!.`val`)
        return false

    return search(root1, root2)
}

fun search(root1: TreeNode, root2: TreeNode): Boolean {
    var leftNulls = 0
    var rightNulls = 0
    if (root1.left == null)
        leftNulls++
    if (root1.right == null)
        leftNulls++
    if (root2.right == null)
        rightNulls++
    if (root2.left == null)
        rightNulls++

    if (leftNulls != rightNulls)
        return false

    var result = true

    if (root1.left != null && root2.left != null) {
        if (root1.left?.`val` == root2.left?.`val`) {
            if (root1.right?.`val` != root2.right?.`val`) {
                return false
            }
            result = result && search(root1.left!!, root2.left!!)
        }
    }

    if (root1.right != null && root2.right != null) {
        if (root1.right?.`val` == root2.right?.`val`) {
            if (root1.left?.`val` != root2.left?.`val`) {
                return false
            }
            result = result && search(root1.right!!, root2.right!!)
        }
    }

    if (root1.right != null && root2.left != null) {
        if (root1.right?.`val` == root2.left?.`val`) {
            if (root1.left?.`val` != root2.right?.`val`) {
                return false
            }
            result = result && search(root1.right!!, root2.left!!)
        }
    }

    if (root1.left != null && root2.right != null) {
        if (root1.left?.`val` == root2.right?.`val`) {
            if (root1.right?.`val` != root2.left?.`val`) {
                return false
            }
            result = result && search(root1.left!!, root2.right!!)
        }
    }

    return result
}
