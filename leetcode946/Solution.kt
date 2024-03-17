package com.harera.leetcode.leetcode946

import java.util.*

class Solution {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val quque = LinkedList<Int>()
        quque.addAll(popped.toList())
        val stack = Stack<Int>()
        pushed.forEach {
            stack.push(it)
            while (stack.isNotEmpty() && quque.isNotEmpty() && stack.peek() == quque.peek()) {
                stack.pop()
                quque.poll()
            }
        }
        if (stack.isEmpty() && quque.isEmpty())
            return true
        return false
    }
}


fun main() {
    val solution = Solution()
    println(solution.validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 5, 3, 2, 1)))
    println(solution.validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 3, 5, 1, 2)))
    println(solution.validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 5, 3, 2, 1)))
    println(solution.validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 3, 5, 1, 2)))
    println(solution.validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 5, 3, 2, 1)))
    println(solution.validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 3, 5, 1, 2)))
    println(solution.validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 5, 3, 2, 1)))
    println(solution.validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 3, 5, 1, 2)))
    println(solution.validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 5, 3, 2, 1)))
    println(solution.validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 3, 5, 1, 2)))
    println(solution.validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 5, 3, 2, 1)))
    println(solution.validateStackSequences(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 3, 5, 1, 2)))
}