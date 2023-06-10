package com.harera.leetcode.leetcode138

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}


class Solution {

    private val nodes = HashMap<Node, Node>()
    private val nodeIndices = HashMap<Node, Int>()

    fun copyRandomList(node: Node?): Node? {
        if (node == null)
            return node

        var copiedNode = Node(node.`val`)
        nodes.set(node, copiedNode)

        var head = node.next
        var copiedHead = copiedNode
        var index = 0
        while (head != null) {
            nodes.set(head, Node(head.`val`))
            nodeIndices.set(head, index++)

            copiedHead.next = nodes.get(head)
            head = head.next
            copiedHead = copiedHead.next!!
        }
        head = node
        copiedHead = copiedNode
        while (head != null) {
            copiedHead.random = nodes[head.random]
            head = head.next
            copiedHead = copiedHead.next ?: Node(0)
        }
        return copiedNode
    }
}

fun main() {
//    [[3,null],[3,0],[3,null]]
    val node1 = Node(3)
    val node2 = Node(3)
    val node3 = Node(3)
    node1.next = node2
    node2.next = node3
    node1.random = null
    node2.random = node1
    node3.random = null
    println(Solution().copyRandomList(node1))
}