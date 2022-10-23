package LeetCode350

import java.util.*

internal class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val ans: MutableList<Int?> = arrayListOf()
        Arrays.sort(nums1)
        Arrays.sort(nums2)
        run {
            var i = 0
            var j = 0
            while (i < nums1.size) {
                while (j < nums2.size && nums2[j] <= nums1[i]) {
                    if (nums1[i] == nums2[j]) {
                        ans.add(nums1[i])
                        j++
                        break
                    }
                    j++
                }
                i++
            }
        }
        val a = IntArray(ans.size)
        for (i in a.indices) {
            a[i] = ans[i]!!
        }
        return a
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val a = intArrayOf(1, 2, 2, 1)
            val b = intArrayOf(2)
            val ans = Solution().intersect(a, b)
            for (i in ans.indices) {
                println(ans[i])
            }
        }
    }
}