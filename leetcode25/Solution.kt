package com.harera.leetcode.leetcode25

import java.util.*

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val list = mutableListOf<Stack<ListNode>>()
        var current = head
        var stack = Stack<ListNode>()
        while (current != null) {
            if (stack.size >= k) {
                list.add(stack)
                stack = Stack()
            }
            stack.push(current)
            current = current.next
        }

        val answer = ListNode(0)
        var _answer = answer
        list.forEach {
            while (it.isNotEmpty()) {
                it.peek().next = null
                _answer.next = it.pop()
                _answer = _answer.next!!
            }
        }

        if (stack.size < k)
            stack.reverse()
        while (stack.isNotEmpty()) {
            stack.peek().next = null
            _answer.next = stack.pop()
            _answer = _answer.next!!
        }

        return answer.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


fun main() {
    val solution = Solution()
    val head = ListNode(1)
    var current = head
    for (i in 2..5) {
        current.next = ListNode(i)
        current = current.next!!
    }
    solution.reverseKGroup(head, 2)
}