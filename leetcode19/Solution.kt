package com.harera.leetcode.leetcode19


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null)
            return null

        var tempHead = head
        var size = 0
        while (tempHead != null) {
            size++
            tempHead = tempHead.next
        }

        if (size == 1) {
            return null
        }

        if (size == n) {
            return head.next
        }

        tempHead = head
        var idx = 1
        while (true) {
            if (idx == size - n) {
                tempHead?.next = tempHead?.next?.next
                break
            }
            tempHead = tempHead!!.next
            idx++
        }
        return head
    }
}


fun main() {
    arrayOf(
        ListNode(1).apply {
            next = ListNode(2).apply {
                next = ListNode(3).apply {
                    next = ListNode(4).apply {
                        next = ListNode(5)
                    }
                }
            }
        },
        ListNode(1).apply {
            next = ListNode(2)
        },
        ListNode(1),
        null,
    ).forEach {
        println(
            Solution().removeNthFromEnd(it, 1)?.`val`
        )
    }
}