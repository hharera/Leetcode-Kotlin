package com.harera.leetcode.leetcode382

class Solution(val head: ListNode?) {

    private var _head = head

    fun getRandom(): Int {
        if(_head == null)
            _head = head

        return _head!!.`val`.also {
            _head = _head?.next
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun main() {
    val solution = Solution(
        ListNode(1).also {
            it.next = ListNode(2).also {
                it.next = ListNode(3)
            }
        }
    )
    println(solution.getRandom())
}