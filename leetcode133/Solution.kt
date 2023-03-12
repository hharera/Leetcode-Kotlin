package com.harera.leetcode.leetcode133



class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}


class Solution {

    val visited = Array<Node?>(105) { null }

    fun cloneGraph(node: Node?): Node? {
        return dfs(node)
    }

    private fun dfs(node: Node?): Node? {
        if (node == null)
            return null

        if (visited[node.`val`] != null)
            return visited[node.`val`]

        val result  = Node(node.`val`)
        result.neighbors = arrayListOf()
        visited[node.`val`] = result

        node.neighbors.forEach {
            result.neighbors.add(dfs(it))
        }

        return result
    }
}


fun main() {
    val solution = Solution()
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    node1.neighbors = arrayListOf(node2, node4)
    node2.neighbors = arrayListOf(node1, node3)
    node3.neighbors = arrayListOf(node2, node4)
    node4.neighbors = arrayListOf(node1, node3)
    solution.cloneGraph(node1).let {
        println(it)
    }
}