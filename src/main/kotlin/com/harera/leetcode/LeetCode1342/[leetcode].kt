package LeetCode1342

internal class Solution {
    fun numberOfSteps(num: Int): Int {
        var num = num
        var ans = 0
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2
            } else {
                num--
            }
            ans++
        }
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution().numberOfSteps(123))
        }
    }
}