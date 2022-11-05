package com.harera.leetcode.leetcode206


//var li = ListNode(5)
//var v = li.`val`
//Definition for singly-linked list.
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    var head: ListNode = ListNode(0)
    var temp: ListNode? = head

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null)
            return null

        dfs(head)
        return this.head.next
    }

    private fun dfs(cur: ListNode?) {
        if (cur == null)
            return

        dfs(cur.next)
        temp?.next = ListNode(cur.`val`)
        temp = temp?.next
    }
}

fun main() {
    println(
        Solution().reverseList(
            ListNode(5).apply {
                next = ListNode(4).apply {
                    next = ListNode(3).apply {
                        next = ListNode(2).apply {
                            next = ListNode(1)
                        }
                    }
                }
            }
        )?.`val`
    )
}