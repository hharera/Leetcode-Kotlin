package com.harera.leetcode.leetcode315

class Solution {

    fun countSmaller(nums: IntArray): List<Int> {
        val list = mutableListOf<Int>()
        list.add(nums.last())
        val answer = mutableListOf(0)
        for (idx in nums.lastIndex - 1 downTo 0) {
            val it = nums[idx]
            answer.add(countLess(list, it))
            list.add(it)
            list.sort()
        }
        return answer.reversed()
    }

    private fun countLess(list: MutableList<Int>, it: Int): Int {
        if (list.last() < it)
            return list.size
        if (list.first() >= it)
            return 0

        var start = 0
        var end = list.lastIndex
        var mid = 0
        while (start < end) {
            mid = (start + end) / 2
            val cur = list[mid]
            if (cur < it)
                start = cur
            else
                end = cur - 1
        }
        return mid + 1
    }
}

fun main() {
    val solution = Solution()
    println(solution.countSmaller(intArrayOf(5, 2, 6, 1)))
}
// 1 2 5 6
// 3 1 0 2
// 