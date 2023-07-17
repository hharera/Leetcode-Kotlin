package com.harera.leetcode.leetcode537

import java.util.*

class Solution {
    fun complexNumberMultiply(num1: String, num2: String): String {
        val real = LinkedList<Int>()
        val imaginary = LinkedList<Int>()

        val nums1 = num1.split("+")
        val nums2 = num2.split("+")

        real.add(nums1.first().toInt() * nums2.first().toInt())
        imaginary.add(
            nums1.first().toInt() * nums2.last()
                .replace("i", "").toInt()
        )
        imaginary.add(
            nums1.last().replace("i", "")
                .toInt() * nums2.first().toInt()
        )
        real.add(
            nums1.last()
                .replace("i", "")
                .toInt() * nums2.last()
                .replace("i", "").toInt() * -1
        )
        return "${real.sum()}+${imaginary.sum()}i"
    }
}

// 3 parts will remove from them firstly the i and then will add i
// in the last part multiply by -1
// 1 + 1i + 1i -1


fun main() {

}
