package com.harera.leetcode.leetcode238

class Solution {

    fun productExceptSelf(nums: IntArray): IntArray {
        val answers = mutableListOf<Int>()
        var multiResult = 1
        var countZeros = 0

        nums.forEach {
            if (it == 0)
                countZeros++
            else
                multiResult *= it
        }

        nums.forEach {
            if (countZeros == 0) {
                answers.add(multiResult / it)
            } else if (countZeros > 1) {
                answers.add(0)
            } else {
                if (it == 0)
                    answers.add(multiResult)
                else
                    answers.add(0)
            }
        }
        return answers.toIntArray()
    }
}

fun main() {

}
