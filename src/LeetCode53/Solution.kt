package LeetCode53

fun main() {
    println(
        maxSubArray(
            arrayOf(
               -2,-1
            ).toIntArray()
        )
    )
}


fun maxSubArray(nums: IntArray): Int {
    val comulative = IntArray(nums.size + 1)

    var max = Int.MIN_VALUE
    var maxIdx = Int.MIN_VALUE

    nums.forEachIndexed { index, i ->
        comulative[index + 1] = comulative[index] + nums[index]
        if (comulative[index + 1] > max) {
            max = comulative[index + 1]
            maxIdx = index + 1

        }
    }

    var ans = Int.MIN_VALUE
    var sum = 0
    for (i in maxIdx - 1 downTo 0) {
        sum += nums[i]

        if (sum > ans) {
            ans = sum
        }
    }
    return ans
}