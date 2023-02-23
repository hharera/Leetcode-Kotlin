package com.harera.leetcode.leetcode347

class Solution {

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>()
        val frequencyList = Array<MutableList<Int>>(nums.size + 1) { arrayListOf() }

        nums.forEach {
            val frequency = frequencyMap.getOrDefault(it, 0) + 1
            frequencyMap.set(it, frequency)
            frequencyList[frequency].add(it)
        }

        val result = mutableSetOf<Int>()
        for (idx in frequencyList.lastIndex downTo 0) {
            frequencyList[idx].forEach {
                if (result.size >= k)
                    return result.toIntArray()
                result.add(it)
            }
        }
        return result.toIntArray()
    }
}


fun main() {
    val solution = Solution()
    println(solution.topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).toMutableList())
}