package com.harera.leetcode.leetcode65

class Solution {

    fun isNumber(s: String): Boolean {
        var s = s.trim().replace('E', 'e')
        val isValid = { c: Char -> c.isDigit() || c == 'e' || c == '.' || c == '+' || c == '-' }
        val allValid = s.all { isValid(it) }
        if (!allValid)
            return false

        val ecount = s.count { it == 'e' }
        if (ecount > 1)
            return false
        if (ecount == 1) {
            val s1 = s.split("e")[0]
            val s2 = s.split("e")[1]
            return s1.isNotBlank() && s2.isNotBlank() &&
                    isInt(s2) && if (s1.contains('.')) {
                isDouble(s1)
            } else {
                isInt(s1)
            }
        } else {
            return if (s.contains('.')) {
                isDouble(s)
            } else {
                isInt(s)
            }
        }
    }

    private fun isInt(s2: String): Boolean {
        if (s2 == "+" || s2 == "-")
            return false

        var idx = 0
        while (idx < s2.length) {
            if (s2[idx] == '.' || s2[idx] == 'e')
                return false
            if ((s2[idx] == '+' || s2[idx] == '-') && idx != 0)
                return false
            idx++
        }
        return true
    }

    private fun isDouble(s2: String): Boolean {
        if (s2 == "." || s2.count { it == '.' } > 1)
            return false
        val strings = s2.split('.')
        if (strings[1].contains("+") || strings[1].contains("-"))
            return false
        return isInt(strings[0]) && isInt(strings[1])
    }
}

fun main() {
    val solution = Solution()
//    println(solution.isNumber("0"))
    println(solution.isNumber(".1"))
    println(solution.isNumber("abc"))
    println(solution.isNumber("1 a"))
    println(solution.isNumber("2e10"))
    println(solution.isNumber(" -90e3   "))
    println(solution.isNumber(" 1e"))
    println(solution.isNumber("e3"))
    println(solution.isNumber(" 6e-1"))
    println(solution.isNumber(" 99e2.5 "))
    println(solution.isNumber("53.5e93"))
    println(solution.isNumber(" --6 "))
    println(solution.isNumber("-+3"))
    println(solution.isNumber("95a54e53"))
    println(solution.isNumber(".1"))
    println(solution.isNumber("3."))
    println(solution.isNumber("3."))
    println(solution.isNumber("."))
    println(solution.isNumber("e9"))
    println(solution.isNumber("e"))
    println(solution.isNumber(".e1"))
    println(solution.isNumber("4e+"))
    println(solution.isNumber(" "))
    println(solution.isNumber("0"))
    println(solution.isNumber("0.1"))
    println(solution.isNumber("abc"))
    println(solution.isNumber("1 a"))
    println(solution.isNumber("2e10"))
    println(solution.isNumber(" -90e3   "))
    println(solution.isNumber(" 1e"))
    println(solution.isNumber("e3"))
    println(solution.isNumber(" 6e-1"))
    println(solution.isNumber(" 99e2.5 "))
    println(solution.isNumber("53.5e93"))
    println(solution.isNumber(" --6 "))
    println(solution.isNumber("-+3"))
    println(solution.isNumber("95a54e53"))
    println(solution.isNumber(".1"))
    println(solution.isNumber("3."))
    println(solution.isNumber("3."))
    println(solution.isNumber("."))
    println(solution.isNumber("e9"))
    println(solution.isNumber("e"))
    println(solution.isNumber(".e1"))
    println(solution.isNumber("4e+"))
    println(solution.isNumber(" "))
    println(solution.isNumber("0"))
    println(solution.isNumber("0.1"))
    println(solution.isNumber("abc"))
    println(solution.isNumber("1 a"))
    println(solution.isNumber("2e10"))
    println(solution.isNumber(" -90e3   "))
}