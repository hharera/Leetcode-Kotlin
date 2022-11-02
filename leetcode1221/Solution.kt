package LeetCode1221

internal class Solution {
    fun balancedStringSplit(s: String): Int {
        var ans = 1
        var p = s[0]
        var c = 'C'
        var next: Char
        for (i in 1 until s.length) {
            next = s[i]
            if (next != p && next != c) {
                c = next
            } else if (next == p && c != 'C') {
                p = next
                c = 'C'
                ans++
            }
        }
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution().balancedStringSplit("RLRRRLLRLL"))
        }
    }
}