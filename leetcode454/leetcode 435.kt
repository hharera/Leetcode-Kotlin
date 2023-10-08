package com.harera.leetcode.leetcode454


class Solution {
    fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        val num4Set = nums4.groupBy {
            it
        }.map {
            it.key to it.value.size
        }.toMap()


        var answer = 0
        for (num1 in nums1) {
            for (num2 in nums2) {
                for (num3 in nums3) {
                    val sum = num1 + num2 + num3
                    if (num4Set.contains(0 - sum)) {
                        answer += num4Set[0 - sum]!!
                    }
                }
            }
        }
        return answer
    }
}

fun main(args: Array<String>) {
    //nums1 =
    //[0,1,-1]
    //nums2 =
    //[-1,1,0]
    //nums3 =
    //[0,0,1]
    //nums4 =
    //[-1,1,1]

    println(
        Solution().fourSumCount(
            intArrayOf(0, 1, -1),
            intArrayOf(-1, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(-1, 1, 1)
        )
    )

    println(Solution().fourSumCount(intArrayOf(1, 2), intArrayOf(-2, -1), intArrayOf(-1, 2), intArrayOf(0, 2)))
}