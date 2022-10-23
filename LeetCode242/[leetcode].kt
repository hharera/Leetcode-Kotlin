package LeetCode242

internal class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val a = IntArray(26)
        val b = IntArray(26)
        var isEqual: Boolean
        for (i in 0 until s.length) {
            a[s[i].code - 'a'.code]++
        }
        for (i in 0 until t.length) {
            b[t[i].code - 'a'.code]++
        }
        for (i in 0..25) {
            if (a[i] != b[i]) {
                return false
            }
        }
        return true
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution().isAnagram("a", "ab"))
        }
    }
}