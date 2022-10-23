package LeetCode1480

internal class Solution {
    fun runningSum(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        for (i in nums.indices) {
            var curr = 0
            for (j in 0..i) {
                curr += nums[j]
            }
            ans[i] = curr
        }
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val test = intArrayOf(1, 2, 5, 8, 9)
            val ans = Solution().runningSum(test)
            for (i in ans.indices) {
                println(ans[i])
            }
        }
    }
}