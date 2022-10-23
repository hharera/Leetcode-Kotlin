package com.harera.leetcode

fun main() {
    var result = (
        removeNthFromEnd(
            ListNode(1).apply {
                next = ListNode(2).apply {
                    next = ListNode(3).apply {
                        next = ListNode(4).apply {
                            next = ListNode(5)
                        }
                    }
                }
            }, 2
        )
    )
    while (result != null) {
        println(result.`val`)
        result = result.next
    }
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null)
        return head

    var cur = head
    var size = 0
    while (cur != null) {
        size++
        cur = cur.next
    }

    if (size == 1) {
        return null
    }

    if (size == n) {
        return head.next
    }

    cur = head.next
    var _previous = head
    var count = 0
    while (count < size - n - 1) {
        cur = cur!!.next
        _previous = _previous!!.next
        count++
    }
    _previous!!.next = cur!!.next

    return head
}


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
