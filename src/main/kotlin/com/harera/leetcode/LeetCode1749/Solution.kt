package LeetCode1749

import kotlin.math.abs

fun maxAbsoluteSum(nums: IntArray): Int {

    val allPossibleSolutions = ArrayList<Long>()
    for (i in nums.indices) {
        var sum = nums[i]
        allPossibleSolutions.add(sum.toLong())
        for (j in (i + 1)..nums.size - 1) {
            sum += nums[j]
            allPossibleSolutions.add(sum.toLong())
        }
    }

    allPossibleSolutions.sort()
    if (abs(allPossibleSolutions[0]) >= abs(allPossibleSolutions[allPossibleSolutions.lastIndex]))
        return abs(allPossibleSolutions[0].toInt())
    else
        return abs(allPossibleSolutions[allPossibleSolutions.lastIndex].toInt())
}

fun main() {
    println(
        maxAbsoluteSum(
            arrayOf(
                1, -3, 2, 3, -4
            ).toIntArray()
        )
    )
}
