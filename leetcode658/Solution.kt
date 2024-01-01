package com.harera.leetcode.leetcode658

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        var lessIdx = findLessThanOrEqualX(arr, x)
        var greaterIdx = findGreaterThanOrEqualX(arr, x)
        var remaining = k
        if (lessIdx == greaterIdx)
            lessIdx -= 1

        val result = mutableListOf<Int>()
        while (lessIdx >= 0 && greaterIdx < arr.size && remaining > 0) {
            if (x - arr[lessIdx] <= arr[greaterIdx] - x) {
                result.add(arr[lessIdx])
                lessIdx--
            } else {
                result.add(arr[greaterIdx])
                greaterIdx++
            }
            remaining--
        }

        while (remaining > 0) {
            if (lessIdx < 0) {
                result.add(arr[greaterIdx])
                greaterIdx++
            } else if (greaterIdx > arr.lastIndex) {
                result.add(arr[lessIdx])
                lessIdx--
            }
            remaining--
        }
        return result.sorted()
    }

    private fun findGreaterThanOrEqualX(arr: IntArray, x: Int): Int {
        var start = 0
        var end = arr.size - 1
        while (start < end) {
            val mid = start + (end - start) / 2
            if (arr[mid] >= x) {
                end = mid
            } else {
                start = mid + 1
            }
        }
        return start
    }

    private fun findLessThanOrEqualX(arr: IntArray, x: Int): Int {
        var start = 0
        var end = arr.size - 1
        while (start < end) {
            val mid = start + (end - start) / 2
            if (arr[mid] <= x) {
                start = mid
            } else {
                end = mid - 1
            }
        }
        return start
    }
}

fun main() {
    val solution = Solution()
    println(solution.findClosestElements(intArrayOf(1,1,2,3,3,3,4,6,8,8), 1, 6))
}