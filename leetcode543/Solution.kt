package LeetCode543

fun main() {
    println(
        diameterOfBinaryTree(
            TreeNode(1).apply {
                right = TreeNode(2).apply {
                    right = TreeNode(5).apply {
                        right = TreeNode(2).apply {
                            right = TreeNode(5).apply {
                                right = TreeNode(2).apply {
                                    right = TreeNode(5).apply {
                                        right = TreeNode(2).apply {
                                            right = TreeNode(5).apply {
                                                right = TreeNode(2).apply {
                                                    right = TreeNode(5).apply {

                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                left = TreeNode(5).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(5).apply {
                            left = TreeNode(5).apply {
                                left = TreeNode(5).apply {
                                    left = TreeNode(5).apply {

                                    }
                                }
                            }
                        }
                    }
                }
            }
        )
    )
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

var maxGlobal: Int = 0

fun diameterOfBinaryTree(root: TreeNode?): Int {
    getLongestDiameter(root)
    return maxGlobal
}

fun getLongestDiameter(root: TreeNode?): Int {
    if (root == null)
        return 0

    var max = 0

    val left = getLongestDiameter(root.left)
    max = if (left > max)
        left
    else
        max


    val right = getLongestDiameter(root.right)
    max = if (right > max)
        right
    else
        max

    maxGlobal =  if (left + right > maxGlobal)
        left + right
    else
        maxGlobal

    return max + 1
}
