package LeetCode918

import kotlin.math.max

fun maxSubarraySumCircular(nums: IntArray): Int {
    val arrayList = ArrayList<Pair<Int, Int>>()

    val accumelatedSum = IntArray(nums.size + 1)
    accumelatedSum[0] = 0
    for (idx in 1 until accumelatedSum.size) {
        accumelatedSum[idx] = accumelatedSum[idx - 1] + nums[idx - 1]
    }

    for (idx1 in nums.indices) {
        for (idx2 in idx1 until idx1 + nums.size) {
            arrayList.add(Pair(idx1 + 1, idx2 + 1 % nums.size))
        }
    }

    var ans = 0
    arrayList.forEach {
        if (it.first <= it.second)
            ans = max(
                accumelatedSum[it.second % nums.size] - accumelatedSum[it.first % nums.size - 1],
                ans
            )
        else {
            ans = max(
                accumelatedSum[accumelatedSum.lastIndex] - accumelatedSum[it.first % nums.size - 1]
                        +
                        accumelatedSum[it.second % nums.size],
                ans
            )
        }
    }

    return ans
}

fun main() {
    println(
        maxSubarraySumCircular(
            arrayOf<Int>(
                5, -3, 5
            ).toIntArray()
        )
    )
}