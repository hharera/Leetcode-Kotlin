package LeetCode11

fun maxArea(height: IntArray): Int {
    var ans = Int.MIN_VALUE
    var start = 0
    var end = height.lastIndex

    while (start < end) {
        val size = (end - start) * if (height[start] > height[end]) height[end] else height[start]
        if (ans < size)
            ans = size

        if (height[start] > height[end])
            end--
        else
            start++
    }

    return ans
}

fun main() {
    println(
        maxArea(
            arrayOf(
                1, 1
            ).toIntArray()
        )
    )
}