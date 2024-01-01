package com.harera.leetcode.leetcode532

class Solution {
    fun findPairs(nums: IntArray, k: Int): Int {
        val map = mutableMapOf<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        var result = 0
        if (k == 0) {
            map.values.forEach {
                if (it > 1)
                    result += 1
            }
            return result
        }

        map.keys.sorted().forEach {
            val nextElement = it + k
            if (map.contains(nextElement))
                result += 1

        }
        return result
    }
}

fun main() {
    println(Solution().findPairs(intArrayOf(1,2,4,4,3,3,0,9,2,3), 3))
    println(Solution().findPairs(intArrayOf(1, 2, 3, 4, 5), 1))
    println(Solution().findPairs(intArrayOf(1, 3, 1, 5, 4), 0))
    println(Solution().findPairs(intArrayOf(1, 1, 1, 1, 1), 0))
}