package com.harera.leetcode.leetcode4

import java.util.Comparator


class Solution {

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var mid = 0
        var odd = true
        if ((nums1.size + nums2.size) % 2 == 0) {
            mid = (nums1.size + nums2.size) / 2 - 1
            odd = false
        } else {
            mid = (nums1.size + nums2.size) / 2
        }

        var index1 = 0
        var index2 = 0
        var answer: Double
        val list = mutableListOf<Int>()
        while (index1 < nums1.size && index2 < nums2.size) {
            if (nums1[index1] <= nums2[index2]) {
                list.add(nums1[index1])
                index1++
            } else {
                list.add(nums2[index2])
                index2++
            }
        }
        while (index1 < nums1.size) {
            list.add(nums1[index1])
            index1++
        }
        while (index2 < nums2.size) {
            list.add(nums2[index2])
            index2++
        }
        if (!odd)
            answer = (list.get(mid).toDouble() + list.get(mid + 1).toDouble()) / 2
        else
            answer = (list.get(mid)).toDouble()
        return answer
    }
}

fun main() {
    val solution = Solution()
    println(solution.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2, 4)))
}


// list_1 : [1, 2, 3] list_2 : [2, 4, 6]