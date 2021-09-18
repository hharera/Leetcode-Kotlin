package LeetCode560

class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {

        var ans = 0
        for (idx1 in 0 until nums.size) {
            var sum = nums[idx1]
            if (sum == k)
                ans++

            for (idx2 in idx1 + 1 until nums.size) {
                sum += nums[idx2]
                if (sum == k)
                    ans++
            }
        }
        return ans
    }
}
