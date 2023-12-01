package com.harera.leetcode.leetcode55

import java.util.*

class Solution {
    fun canJump(nums: IntArray): Boolean {
        val visited = Array(10001) { false }
        var stack: Stack<Int> = Stack()
        stack.add(nums.lastIndex)
        while (stack.isNotEmpty()) {
            val cur = stack.pop()
            if (cur == 0)
                return true
            if (visited[cur])
                continue
            for (idx in cur - 1 downTo 0) {
                if (nums[idx] >= cur - idx) {
                    stack.push(idx)
                }
            }
            visited[cur] = true
        }
        return false
    }
}

fun main() {
    val solution = Solution()
    println(solution.canJump(intArrayOf(3, 2, 1, 0, 4)))
}