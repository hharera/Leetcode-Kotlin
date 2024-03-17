package com.harera.leetcode.leetcode282

class Solution {
    fun addOperators(num: String, target: Int): List<String> {
        return solve(idx = 1, num, target)
    }

    private fun solve(idx: Int = 1, num: String, target: Int): List<String> {
        if (idx > num.lastIndex) {
            if (evaluate(num) == target) return listOf(num)
            return emptyList()
        }

        var result = listOf<String>()
        result += solve(idx + 2, num.substring(0, idx) + "*" + num.substring(idx, num.length), target)
        result += solve(idx + 2, num.substring(0, idx) + "+" + num.substring(idx, num.length), target)
        result += solve(idx + 2, num.substring(0, idx) + "-" + num.substring(idx, num.length), target)
        return result
    }

    fun evaluate(expression: String): Int {
        val additionParts = expression.split('+')
        var sum = 0
        for (part in additionParts) {
            val subtractionParts = part.split('-')
            var result = 0
            for ((index, subtractionPart) in subtractionParts.withIndex()) {
                val multiplicationParts = subtractionPart.split('*')
                var product = 1
                for (multiplicationPart in multiplicationParts) {
                    product *= multiplicationPart.trim().toInt()
                }
                if (index == 0 || index > 0 && part[index - 1] == '+') {
                    result += product
                } else {
                    result -= product
                }
            }
            sum += result
        }
        return sum
    }
}

fun main() {
    val solution = Solution()
    println(solution.addOperators("123", 6))
}

