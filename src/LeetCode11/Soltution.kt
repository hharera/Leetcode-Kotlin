package LeetCode11

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min


data class Bar(
    val idx: Int,
    val height: Int,
) : Comparable<Bar> {
    override fun compareTo(other: Bar): Int {
        if (other.height == height)
            return other.idx - idx
        return height - other.height
    }
}

fun maxArea(height: IntArray): Int {
    return search(0, height.lastIndex, height.asList())
}

fun search(start: Int, end: Int, heights: List<Int>): Int {
    if (start == end) {
        return 0
    }
    var max = Int.MIN_VALUE
    var height = min(heights[start], heights[end])
    max = max(height * (end - start), max)

    if (heights[start] < heights[end]) {
        max = max(max, search(start + 1, end, heights))
    } else {
        max = max(max, search(start, end - 1, heights))
    }
    return max
}

fun main() {
    println(
        maxArea(
            arrayOf(
                1, 2, 1
            ).toIntArray()
        )
    )
}