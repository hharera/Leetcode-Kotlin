package com.harera.leetcode.leetcode155

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null)
            return null

        if (headA == headB)
            return headA

        var aLength = 0
        var bLength = 0
        var a = headA
        while (a != null) {
            aLength++
            a = a.next
        }

        var b = headB
        while (b != null) {
            bLength++
            b = b.next
        }

        a = headA
        b = headB
        while (aLength != bLength) {
            if (aLength > bLength) {
                a = a?.next
                aLength--
            } else {
                b = b?.next
                bLength--
            }
        }

        return search(a, b)
    }

    private fun search(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null)
            return null

        if (headA == headB)
            return headA

        return search(headA.next, headB.next)
    }
}

fun main() {
    //listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
    val inter = ListNode(8)
    val root = ListNode(4).apply {
        next = ListNode(1).apply {
            next = inter
        }
    }
    val root2 = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(1).apply {
                next = inter.apply {
                    next = ListNode(4).apply {
                        next = ListNode(5)
                    }
                }
            }
        }
    }
    println(Solution().getIntersectionNode(root, root2)?.`val`)
}