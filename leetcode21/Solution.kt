package com.harera.leetcode.leetcode21

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var head = ListNode(0)
        val answer = head
        var l1 = list1
        var l2 = list2
        while (l1 != null && l2 != null) {
            if (l1.`val` <= l2.`val`) {
                head.next = ListNode(l1.`val`)
                l1 = l1.next
            } else {
                head.next = ListNode(l2.`val`)
                l2 = l2.next
            }
            head = head.next!!
        }

        while (l1 != null) {
            head.next = ListNode(l1.`val`)
            head = head.next!!
            l1 = l1.next
        }

        while (l2 != null) {
            head.next = ListNode(l2.`val`)
            head = head.next!!
            l2 = l2.next
        }

        return answer.next
    }
}

fun main(args: Array<String>) {
    Solution().mergeTwoLists(
        ListNode(-10).apply {
            next = ListNode(-9).apply {
                next = ListNode(-4).apply {
                    next = ListNode(1).apply {
                        next = ListNode(6).apply {
                            next = ListNode(6)
                        }
                    }
                }
            }
        },
        null
    ).let {
        println(it?.`val`)
    }
}