package LeetCode1470

internal class Solution {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val ans = IntArray(nums.size)
        run {
            var i = 0
            var j = 0
            while (i < n) {
                ans[j] = nums[i]
                i++
                j += 2
            }
        }
        var i = n
        var j = 1
        while (i < nums.size) {
            ans[j] = nums[i]
            i++
            j += 2
        }
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val test = intArrayOf(1, 2, 8, 9, 7, 9)
            val ans = Solution().shuffle(test, 3)
            for (i in ans.indices) {
                println(ans[i])
            }
        }
    }
}