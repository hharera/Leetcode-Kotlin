package Leetcode905

internal class Solution {
    fun sortArrayByParity(A: IntArray): IntArray {
        val odd: MutableList<Int?> = arrayListOf()
        val even: MutableList<Int?> = arrayListOf()
        for (i in A.indices) {
            if (A[i] % 2 == 0) {
                even.add(A[i])
            } else {
                odd.add(A[i])
            }
        }
        val ans = IntArray(A.size)
        var count = 0
        run {
            var i = 0
            while (i < even.size) {
                ans[count] = even[i]!!
                i++
                count++
            }
        }
        var i = 0
        while (i < odd.size) {
            ans[count] = odd[i]!!
            i++
            count++
        }
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
            val ans = Solution().sortArrayByParity(arr)
            for (i in ans.indices) {
                println(ans[i])
            }
        }
    }
}