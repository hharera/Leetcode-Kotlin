package LeetCode1323

internal class Solution {
    fun maximum69Number(num: Int): Int {
        val n = StringBuilder().append(num)
        var ans: StringBuilder? = null
        for (i in 0 until n.length) {
            if (n[i] == '6') {
                ans = StringBuilder()
                ans = ans.append(n.subSequence(0, i)).append("9").append(n.substring(i + 1, n.length))
                break
            }
        }
        if (ans == null) {
            ans = StringBuilder().append(n)
        }
        return ans.toString().toInt()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution().maximum69Number(9999))
        }
    }
}