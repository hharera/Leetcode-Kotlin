package com.harera.leetcode.leetcode682

import java.util.*

class Solution {
    fun calPoints(operations: Array<String>): Int {
        val records = Stack<String>()
        for (operation in operations) {
            if (operation.last().isDigit()) {
                records.add(operation)
            } else if (operation == "C") {
                if (records.isNotEmpty())
                    records.pop()
            } else if (operation == "D") {
                if (records.isNotEmpty())
                    records.add((records.peek().toInt() * 2).toString())
            } else if (operation == "+") {
                if (records.size > 1) {
                    val first = records.pop().toInt()
                    val second = records.pop().toInt()
                    records.add(second.toString())
                    records.add(first.toString())
                    records.add((first + second).toString())
                }
            }
        }
        return records.sumBy { it.toInt() }
    }
}

fun main() {
    val solution = Solution()
    println(solution.calPoints(arrayOf("5", "2", "C", "D", "+")))
    println(solution.calPoints(arrayOf("5", "-2", "4", "C", "D", "9", "+", "+")))
}