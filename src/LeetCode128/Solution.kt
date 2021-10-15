package LeetCode128

import kotlin.math.max

fun main() {

    println(
        longestConsecutive(
            arrayOf(
                100, 4, 200, 1, 3, 2
            ).toIntArray()
        )
    )
}

fun longestConsecutive(nums: IntArray): Int {
    var ans = 0
    var counter = 0
    for (num in nums) {
        if (num >= 0) {
            counter++
        } else {
            ans = max(ans, counter)
            counter = 0
        }
    }

    return max(ans, counter)
}