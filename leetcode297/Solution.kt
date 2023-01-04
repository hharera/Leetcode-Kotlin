package com.harera.leetcode.leetcode297


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Codec() {

    private val levelIdxVal = mutableMapOf<String, String>()
    private var idx = 0
    private var serialized = mutableListOf<String>()
    fun serialize(root: TreeNode?): String {
        if (root == null) {
            return ""
        }
        dfsSerialize(root)
        return serialized.joinToString(",")
    }

    private fun dfsSerialize(root: TreeNode?) {
        if (root == null) {
            serialized.add("N")
            return
        }

        serialized.add(root.`val`.toString())
        dfsSerialize(root.left)
        dfsSerialize(root.right)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isBlank())
            return null

        serialized = data.split(",").toMutableList()
        return dfsDeserialize()
    }

    fun dfsDeserialize(): TreeNode? {
        if (serialized.getOrNull(idx) == null || serialized[idx] == "N") {
            idx++
            return null
        }

        val node = TreeNode(serialized[idx].toInt())
        idx++
        node.left = dfsDeserialize()
        node.right = dfsDeserialize()
        return node
    }
}

fun main() {
    val codec = Codec()

    val root = TreeNode(1)
    root.right = TreeNode(2)
    root.right!!.right = TreeNode(3)
    root.right!!.right!!.right = TreeNode(4)
    root.right!!.right!!.right!!.right = TreeNode(5)


    val data = codec.serialize(root)
    println(data)

    val deserialize = codec.deserialize(data)
    println(deserialize)
}