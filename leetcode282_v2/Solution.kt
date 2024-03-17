package com.harera.leetcode.leetcode282_v2

class Solution {
//    fun addOperators(num: String, target: Int): List<String> {
//        val nums = num.map {
//            it - '0'
//        }
//        return solve(nums, num, target)
//    }

//    private fun solve(nums: Stack<Int>, num: String, target: Int): List<String> {
//        if (nums.size == 1) {
//            if (nums.pop() == target)
//                return listOf(num)
//            return emptyList()
//        }
//
//        var asnwer = emptyList<String>()
//        val n1 = nums.pop()
//        val n2 = nums.pop()
//        nums.push(n1 * n2)
//        solve(nums, num, target)
//
//        return result
//    }
//
//    private fun evaluate(expression: String): Int {
//        val numbers = Stack<Int>()
//        val ops = Stack<Char>()
//        var value = ""
//        for (c in expression) {
//            if (c.isDigit()) {
//                value += (c - '0')
//            } else {
//                numbers.push(value.toInt())
//                value = ""
//                if (ops.isNotEmpty()) {
//                    val op = ops.pop()
//                    val op1 = numbers.pop()
//                    val op2 = numbers.pop()
//                    when (op) {
//                        '+' -> numbers.push(op1 + op2)
//                        '-' -> numbers.push(op1 - op2)
//                        '*' -> numbers.push(op1 * op2)
//                        '/' -> numbers.push(op1 / op2)
//                    }
//                }
//                ops.push(c)
//            }
//        }
//        val op = ops.pop()
//        val op1 = value.toInt()
//        val op2 = numbers.pop()
//        when (op) {
//            '+' -> numbers.push(op1 + op2)
//            '-' -> numbers.push(op1 - op2)
//            '*' -> numbers.push(op1 * op2)
//            '/' -> numbers.push(op1 / op2)
//        }
//        return numbers.pop()
//    }
}

//fun main() {
//    val solution = Solution()
//    println(solution.addOperators("123", 6))
//
//}