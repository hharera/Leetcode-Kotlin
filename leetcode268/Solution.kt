package com.harera.leetcode.leetcode268

fun missingNumber(nums: IntArray): Int {
    var sum: Long = 0
    for (i in 1..nums.size) {
        sum += i
    }

    nums.forEach {
        sum -= it
    }

    println(sum)
    return sum.toInt()
}

fun main() {
    missingNumber(
        arrayOf(
            9, 6, 4, 2, 3, 5, 7, 0, 1
        ).toIntArray()
    )
}