package com.harera.leetcode.leetcode237

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

class Solution {

    fun deleteNode(node: ListNode?) {
        if (node == null)
            return
        var tempNode: ListNode = node
        while (tempNode.next != null) {
            tempNode.`val` = tempNode.next!!.`val`
            if (tempNode.next?.next == null) {
                tempNode.next = null
                break
            }
            tempNode = tempNode.next!!
        }
    }
}

fun main() {

}
