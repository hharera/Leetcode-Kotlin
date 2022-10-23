package LeetCode173

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class BSTIterator(root: TreeNode?) {
    val queue = LinkedList<TreeNode>()

    init {
        getNodes(root)
    }

    private fun getNodes(root: TreeNode?) {
        if (root == null)
            return

        getNodes(root.left)
        queue.add(root)
        getNodes(root.right)
    }

    fun next(): Int {
        return queue.poll().`val`
    }

    fun hasNext(): Boolean {
        return queue.isNotEmpty()
    }
}
