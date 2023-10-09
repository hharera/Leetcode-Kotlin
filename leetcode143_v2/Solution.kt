package com.harera.leetcode.leetcode143_v2

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


class Solution {
    fun reorderList(head: ListNode?): Unit {
        var tempHead: ListNode? = head
        var left = head
        var right = head

        while (left != null && right != null) {
            left = left.next
            right = right.next?.next
        }

        while (left != null) {
            val tempNext = tempHead?.next
            tempHead?.next = ListNode(left.`val`)
            tempHead?.next?.next = tempNext
            tempHead = tempHead?.next?.next
            left = left.next
        }
        tempHead?.next = null
    }
}

fun main() {
    val solution = Solution()
    val node = ListNode(1).apply {
        next = ListNode(1)
    }.apply {
        next = ListNode(2)
    }.apply {
        next = ListNode(3)
    }.apply {
        next = ListNode(4)
    }.apply {
        next = ListNode(5)
    }.apply {
        next = ListNode(6)
    }.apply {
        next = ListNode(7)
    }
    solution.reorderList(node)
    println(node)
}