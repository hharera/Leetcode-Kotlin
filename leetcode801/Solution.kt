package com.harera.leetcode.leetcode801

class Solution {
    fun minSwap(nums1: IntArray, nums2: IntArray): Int {
        var i = 0
        var j = 0
        val size = nums1.size
        var answer = 0
        while (i < size && j < size) {
            if (isValid(nums1, i, nums1[i]) && isValid(nums2, j, nums2[j])) {
                i++
                j++
                continue
            }
            if (isValid(nums1, i, nums1[i]).not()) {
                if (isValid(nums1, i, nums2[j])) {
                    nums1[i] = nums2[j]
                    answer++
                    i++
                } else {
                    j++
                }
            } else if (isValid(nums2, j, nums2[j]).not()) {
                if (isValid(nums2, j, nums1[i])) {
                    nums2[j] = nums1[i]
                    answer++
                    j++
                } else {
                    i++
                }
            }
        }
        return answer
    }

    fun isValid(nums: IntArray, idx: Int, value: Int): Boolean {
        if (idx > 0 && value <= nums[idx - 1]) return false
        if (idx < nums.lastIndex && value >= nums[idx + 1]) return false
        return true
    }
}

fun main() {
    val solution = Solution()
    println(solution.minSwap(intArrayOf(1, 3, 5, 4), intArrayOf(1, 2, 3, 7)))
}