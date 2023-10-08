package com.harera.leetcode.leetcode1108

import java.util.*

class Solution {

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
}

fun main(args: Array<String>) {

}
