package com.harera.leetcode.leetcode215_v2

import java.util.*

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        if (k == nums.size)
            return nums.min()
        if (k == 1)
            return nums.max()

        val kQueue = PriorityQueue<Int>()
        val nQueue = PriorityQueue<Int>(Comparator.reverseOrder())
        for (idx in 0 until k) {
            kQueue.add(nums[idx])
        }
        for (idx in k..nums.lastIndex) {
            val cur = nums[idx]
            if (kQueue.peek() < cur) {
                nQueue.add(kQueue.poll())
                kQueue.add(cur)
            } else {
                nQueue.add(cur)
            }
        }
        return kQueue.poll()
    }
}

fun main() {
    val solution = Solution()
    println(solution.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
}
