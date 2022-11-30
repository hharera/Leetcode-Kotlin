package com.harera.leetcode.leetcode202

class Solution {
    fun isHappy(n: Int): Boolean {
        val setOfRes = mutableSetOf<Int>()

        var res = n
        while (true) {
            if (setOfRes.contains(res))
                return false
            setOfRes.add(res)

            res.toString().map {
                Integer.parseInt(it.toString())
            }.map {
                Math.pow(it.toDouble(), 2.toDouble()).toInt()
            }.sum().also {
                if (it == 1)
                    return true
                res = it
            }
        }
    }
}

fun main() {
//    [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
    println(
        Solution().isHappy(2)
    )
}