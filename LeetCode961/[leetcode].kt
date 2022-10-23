package LeetCode961

internal class Solution {
    fun repeatedNTimes(A: IntArray): Int {
        var ans = 1
        val map: MutableMap<Int, Int> = HashMap()
        for (i in A.indices) {
            if (map.containsKey(A[i])) {
                ans = A[i]
                break
            } else {
                map[A[i]] = ans
            }
        }
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = intArrayOf(5, 1, 5, 2, 5, 3, 5, 4)
            val ans = Solution().repeatedNTimes(arr)
            println(ans)
        }
    }
}