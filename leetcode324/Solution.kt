package com.harera.leetcode.leetcode324

class Solution {
    fun wiggleSort(nums: IntArray): Unit {
        nums.sort()
        var i = 0
        var j = nums.lastIndex
        val answer = mutableListOf<Int>()
        while (i < j) {
            answer.add(nums[i])
            answer.add(nums[j])

            i++
            j--
        }
        if (answer.size % 2 != 0)
            answer.add(nums[i])

        nums.forEachIndexed { index, i ->
            nums[index] = answer[index]
        }
    }
}

// 1 2 3 4 5 6 7 8 9
// 8 9 6 7 4 5 2 3 1

// 1 1 2 2 3 3
// 1 3 1 3 2 2