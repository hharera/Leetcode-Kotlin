package com.harera.leetcode.leetcode1019

import java.util.*


class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {

    private val results = arrayListOf<Int>()

    fun nextLargerNodes(head: ListNode?): IntArray {
        val priorityQueue = PriorityQueue<Int> { t, t2 ->
            t2 - t
        }
        search(head, priorityQueue)
        return results.reversed().toIntArray()
    }

    private fun search(head: ListNode?, priorityQueue: PriorityQueue<Int>): PriorityQueue<Int> {
        if (head == null) {
            priorityQueue.add(0)
            return priorityQueue
        }

        val result = search(head.next, priorityQueue)
        if(result.peek() > head.`val`) {
            results.add(result.peek())
        } else {
            results.add(0)
        }
        priorityQueue.add(head.`val`)
        return priorityQueue
    }
}

fun main() {
    val solution = Solution()
    println(
        solution.nextLargerNodes(
            //1,7,5,1,9,2,5,1
            ListNode(1).apply {
                next = ListNode(7).apply {
                    next = ListNode(5).apply {
                        next = ListNode(1).apply {
                            next = ListNode(9).apply {
                                next = ListNode(2).apply {
                                    next = ListNode(5).apply {
                                        next = ListNode(1)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        ).contentToString()
    )
}