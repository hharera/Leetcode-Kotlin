package LeetCode709

internal class Solution {
    fun toLowerCase(str: String): String {
        val ans = StringBuilder()
        for (i in 0 until str.length) {
            ans.append(str[i].lowercaseChar())
        }
        return ans.toString()
    }
}