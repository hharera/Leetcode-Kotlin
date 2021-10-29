package LeetCode53

import java.lang.Integer.MIN_VALUE
import java.lang.Integer.max

fun main() {
    println(
        maxSubArray(
            arrayOf(
                -2, 1, -3, 4, -1, 2, 1, -5, 4
            ).toIntArray()
        )
    )
}


fun maxSubArray(nums: IntArray): Int {
    val comulative = IntArray(nums.size)
    comulative.set(0, nums.get(0))
    var ans = nums.get(0)

    for (index in 1..nums.lastIndex) {
        comulative[index] =
            nums.get(index) +
                    if (comulative[index - 1] <= 0)
                        0
                    else
                        comulative[index - 1]

        ans = if (comulative.get(index) > ans)
            comulative.get(index)
        else
            ans
    }

    return ans
}