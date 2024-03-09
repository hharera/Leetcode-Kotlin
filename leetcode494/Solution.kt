package com.harera.leetcode.leetcode494

class Solution {

    private val visited = HashMap<String, Int>()
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        return count(0, nums, 0, target)
    }

    // count (idx, arr, sum, target)
    // if idx > last & sum != target return 0
    // if idx > last & sum == target return 1

    // if visited[idx][sum]
    // return it

    // count (idx+1, arr, sum + arr[idx], target)
    // +
    // count (idx+1, arr, sum - arr[idx], target)

    fun count(idx: Int, arr: IntArray, sum: Int, target: Int): Int {
        if (idx > arr.lastIndex) {
            return if (sum == target) 1 else 0
        }

        if (visited.contains("$idx $sum")) {
            return visited["$idx $sum"]!!
        }

        return (count(idx + 1, arr, sum + arr[idx], target) + count(idx + 1, arr, sum - arr[idx], target)).also {
            visited["$idx $sum"] = it
        }
    }
}


fun main() {
    println(Solution().findTargetSumWays(intArrayOf(1, 1, 1, 1, 1), 3))
}