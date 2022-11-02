package com.harera.leetcode.leetcode26



class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var nums = nums
        val map: MutableMap<Int?, Int?> = HashMap()
        for (i in nums.indices) {
            if (!map.containsKey(nums[i])) {
                map[nums[i]] = i
            }
        }
        val ans = map.keys.size
        nums = IntArray(ans)
        var i = 0
        val set: Set<Int?> = map.keys
        for (inte in set) {
            nums[i] = inte!!
            i++
        }
        return ans
    }

}

fun main(args: Array<String>) {
    println(Solution().removeDuplicates(intArrayOf(1, 1, 2)))
}
