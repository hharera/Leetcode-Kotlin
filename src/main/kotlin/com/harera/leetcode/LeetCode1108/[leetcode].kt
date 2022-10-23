package LeetCode1108

import java.util.*

internal class Solution {
    fun defangIPaddr(address: String?): String? {
        var address = address
        val stk = StringTokenizer(address, ".")
        val sb = StringBuilder()
        while (stk.hasMoreElements()) {
            sb.append(stk.nextToken() + "[.]")
        }
        address = sb.substring(0, sb.length - 3)
        return address
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution().defangIPaddr("1.1.1.1"))
        }
    }
}