package com.harera.leetcode.leetcode143

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


class Solution {
    fun reorderList(head: ListNode?): Unit {
        var tempHead: ListNode? = head
        val arraylist = arrayListOf<Int>()
        while (tempHead != null) {
            arraylist.add(tempHead.`val`)
            tempHead = tempHead.next
        }
        arraylist.reverse()

        if (arraylist.size <= 2)
            return

        tempHead = head
        var idx = 0
        while (idx < arraylist.size / 2) {
            val temp = tempHead?.next
            tempHead?.next = ListNode(arraylist[idx])
            tempHead?.next?.next = temp

            if (idx == (arraylist.size / 2) - 1) {
                tempHead = tempHead?.next
            } else {
                tempHead = tempHead?.next?.next
            }
            idx++
        }
        if (arraylist.size % 2 != 0) {
            tempHead?.next = ListNode(arraylist[idx])
        } else {
            tempHead?.next = null
        }
    }
}

fun main() {
    Solution().reorderList(
        ListNode(1).apply {
            next = ListNode(1)
        }
    )
}