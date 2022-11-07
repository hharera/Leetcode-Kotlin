package com.harera.leetcode.leetcode141


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {


    fun hasCycle(head: ListNode?): Boolean {
        if (head == null)
            return false

        if (head.next == null)
            return false

        var fast = head
        var slow = head

        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                return true
            }
        }

        return false
    }
}


fun main() {
    val root = ListNode(1)
    println(
        Solution().hasCycle(
            root.apply {
                next = ListNode(4).apply {
                    next = ListNode(5).apply {
                        next = ListNode(3).apply {
                            next = ListNode(2).apply {
                                next = root
                            }
                        }
                    }
                }
            }
        )
    )
}