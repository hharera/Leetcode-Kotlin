package LeetCode1365

internal class Solution {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        for (i in nums.indices) {
            for (j in nums.indices) {
                if (i != j && nums[j] < nums[i]) {
                    ans[i]++
                }
            }
        }
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val nums = intArrayOf(8, 1, 2, 2, 3)
            val ans = Solution().smallerNumbersThanCurrent(nums)
            for (an in ans) {
                println(an)
            }
        }
    }
}