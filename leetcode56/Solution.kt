package com.harera.leetcode.leetcode56

import java.util.*

class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        val list = intervals.sortedBy {
            it[0]
        }
        val answer = ArrayList<IntArray>()
        val queue = LinkedList(list)
        while (queue.size > 1) {
            val first = queue.pop()
            val second = queue.peek()
            if (first[1] >= second[0]) {
                second[0] = first[0]
                second[1] = maxOf(first[1], second[1])
            } else {
                answer.add(first)
            }
        }
        answer.add(queue.pop())
        return answer.toTypedArray()
    }
}

fun main() {

}
