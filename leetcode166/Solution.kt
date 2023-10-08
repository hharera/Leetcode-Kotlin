package com.harera.leetcode.leetcode166

class Solution {

    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        val divResult = (numerator.toFloat() / denominator.toFloat())
        val fractionStr = divResult.toString().split(".")[1]
        val possibleFractions = mutableListOf<String>()

        if (fractionStr.toInt() == 0)
            return divResult.toInt().toString()

        var str = ""
        fractionStr.forEach {
            str += it
            possibleFractions.add(str)
        }

        possibleFractions.reversed().forEach {
            var str = fractionStr
            val index = str.indexOf(it)
            str = str.removeRange(index, index + it.length)
            if (str.contains(it))
                return divResult.toString().split(".")[0].plus(".").plus("($it)")
        }
        return divResult.toString()
    }
}

fun main() {
    println(Solution().fractionToDecimal(4, 333))
}