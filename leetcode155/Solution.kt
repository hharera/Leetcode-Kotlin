package com.harera.leetcode.leetcode155

class MinStack() {
    var head: Node? = null

    fun push(`val`: Int) {
        head = Node(
            `val`,
            if (head == null)
                `val`
            else
                if (`val` < head!!.min)
                    `val`
                else
                    head!!.min,
            head
        )
    }

    fun pop() {
        head = head?.next
    }

    fun top(): Int {
        return head!!.`val`
    }

    fun getMin(): Int {
        return head!!.min
    }

    data class Node(
        val `val`: Int,
        val min: Int,
        val next: Node? = null,
    )
}