package LeetCode1295

internal class Solution {
    fun findNumbers(nums: IntArray): Int {
        var ans = 0
        for (i in nums.indices) {
            if (nums[i] % 2 == 0) {
                ans++
            }
        }
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = intArrayOf(12, 345, 2, 6, 7896)
            val ans = Solution().findNumbers(arr)
            println(ans)
        }
    }
}

internal class ListNode {
    var `val` = 0
    var next: ListNode? = null

    constructor() {}
    constructor(`val`: Int) {
        this.`val` = `val`
    }

    constructor(`val`: Int, next: ListNode?) {
        this.`val` = `val`
        this.next = next
    }
}