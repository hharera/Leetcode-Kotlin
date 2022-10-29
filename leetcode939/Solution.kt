package LeetCode939

import kotlin.math.abs
import kotlin.math.max

fun main() {
    println(
        minAreaRect(
            arrayOf(
                arrayOf(3, 3).toIntArray(),
                arrayOf(3, 1).toIntArray(),
                arrayOf(4, 3).toIntArray(),
                arrayOf(4, 1).toIntArray(),
            )
        )
    )
}

fun minAreaRect(points: Array<IntArray>): Int {
    val lines = HashMap<Int, HashSet<Int>>()

    for (point in points) {
        if (lines.containsKey(point[1]))
            lines.get(point[1])!!.add(point[0])
        else {
            lines.set(point[1], HashSet())
            lines.get(point[1])!!.add(point[0])
        }
    }

    var ans = 0
    for (point in points) {
        for (_point in points) {
            if (point[1] == _point[1] && point[0] == _point[0])
                continue

            if (lines.get(point[1])!!.contains(_point[0]) && lines.get(_point[1])!!.contains(point[0])) {
                ans = max(
                    ans,
                    abs(point[0] - _point[0]) * abs(point[1] - _point[1])
                )
            }
        }
    }

    return ans
}