package com.harera.leetcode.leetcode128

fun main() {
    // 8 test cases

    val arr = arrayOf(
        Solution().longestConsecutive(
            arrayOf(
                100, 4, 200, 1, 3, 2
            ).toIntArray()
        ),

        Solution().longestConsecutive(
            arrayOf(
                0, 3, 7, 2, 5, 8, 4, 6, 0, 1
            ).toIntArray()
        ),

        Solution().longestConsecutive(
            arrayOf(
                1, 2, 0, 1
            ).toIntArray()
        ),

        Solution().longestConsecutive(
            arrayOf(
                9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6
            ).toIntArray()
        ),
        Solution().longestConsecutive(
            arrayOf(
                0, 3, 7, 2, 5, 8, 4, 6, 0, 1
            ).toIntArray()
        )
    )

    arr.forEach {
        println(it)
    }
}


class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toSet()
        val stepSet = mutableSetOf<Int>()
        val stepMap = mutableMapOf<Int, Int>()

        numSet.forEach {
            if (it != 0 && numSet.contains(it + it)) {
                stepSet.add(it)
            }
        }

        numSet.forEach { num ->
            stepSet.forEach { step ->
                if (numSet.contains(num + step)) {
                    stepMap[step] = (stepMap[step] ?: 1) + 1
                } else {
                    stepMap[step] = 1
                }
            }
        }

        return stepMap.values.max()
    }
}
