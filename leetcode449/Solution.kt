package com.harera.leetcode.leetcode449

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Codec() {

    fun serialize(root: TreeNode?): String {
        return serialize(root, mutableListOf()).toString()
    }

    fun serialize(root: TreeNode?, result: MutableList<Int?>): MutableList<Int?> {
        if (root == null)
            return result.also { it.add(null) }

        result.add(root.`val`)
        serialize(root.left, result)
        serialize(root.right, result)
        return result
    }

    fun deserialize(data: String): TreeNode? {
        val array = data.drop(1).dropLast(1).split(", ")
        val deserialize = deserialize(array, 0)
        return deserialize.first
    }

    fun deserialize(array: List<String?>, idx: Int): Pair<TreeNode?, Int> {
        if (idx > array.lastIndex)
            return Pair(null, 0)

        if (array[idx] == "null")
            return Pair(null, 1)

        val head = TreeNode(array[idx]!!.toInt())

        val left = deserialize(array, idx + 1)
        val right = deserialize(array, idx + 1 + left.second)

        head.left = left.first
        head.right = right.first

        return Pair(head, 1 + left.second + right.second)
    }
}

fun main() {
    val solution = Codec()
    val serialize = solution.serialize(TreeNode(1).apply {
        left = TreeNode(2)
        right = TreeNode(3)
    })
    solution.deserialize(serialize)
}
