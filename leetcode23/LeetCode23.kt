package com.harera.leetcode.leetcode23

class LeetCode23{


    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val arrayList = ArrayList<Int>()

        while (true) {
            var allIsNull = true

            for (list in lists) {
                if (list != null)
                    allIsNull = false
            }
            if (allIsNull)
                break

            var min = Int.MAX_VALUE
            var minIdx = -1

            for (idx in lists.indices) {
                if (lists[idx] != null) {
                    if (lists[idx]!!.`val` < min) {
                        min = lists[idx]!!.`val`
                        minIdx = idx
                    }
                }
            }
            lists[minIdx] = lists[minIdx]!!.next
            arrayList.add(min)
        }
        if (arrayList.isEmpty())
            return null

        val head = ListNode(arrayList.first())
        var _head: ListNode? = head
        for (i in 1..arrayList.lastIndex) {
            _head!!.next = ListNode(arrayList[i])
            _head = _head.next
        }
        return head
    }
}