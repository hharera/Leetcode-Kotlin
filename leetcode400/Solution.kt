package com.harera.leetcode.leetcode400

class Solution {
    fun findNthDigit(n: Int): Int {
        val arr = Array(12) { 0L }
        for (i in 1..11) {
            arr[i] = arr[i - 1] + 9 * i * Math.pow(10.0, (i - 1).toDouble()).toLong()
        }

        var numberLength = 0
        for (idx in 1..11) {
            if (n <= arr[idx]) {
                numberLength = idx
                break
            }
        }
        var order = (n - arr[numberLength - 1]) / numberLength
        var idx = (n - arr[numberLength - 1]) % numberLength
        if (idx == 0L) {
            order--
            idx = (numberLength - 1).toLong()
        } else {
            idx--
        }

        val number = order + Math.pow(10.0, (numberLength - 1).toDouble()).toLong()
        return number.toString()[idx.toInt()] - '0'
    }
}

fun main() {
    println(Solution().findNthDigit(9))
//    println(Solution().findNthDigit(11))
//    println(Solution().findNthDigit(36))
    println(Solution().findNthDigit(2147483647))
}