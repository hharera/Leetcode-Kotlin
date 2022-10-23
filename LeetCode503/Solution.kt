package LeetCode503

import java.util.*

fun main() {
    arrayOf(
        1,2,1
    ).toIntArray().let {
        println(nextGreaterElements(it).toMutableList())
    }
}

fun nextGreaterElements(nums: IntArray): IntArray {
    val stack = Stack<Pair<Int, Int>>()
    val res = IntArray(nums.size, init = { -1 })

    var idx = 0
    while (idx < (nums.size * 2)) {
        while (stack.isNotEmpty() && stack.peek().second < nums[idx % nums.size]) {
            res[stack.pop().first] = nums[idx % nums.size]
        }

        stack.push(Pair(idx % nums.size, nums[idx % nums.size]))
        idx++
    }

    return res
}
