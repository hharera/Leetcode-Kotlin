package LeetCode973

import java.lang.Math.pow



fun main() {
    kClosest(
        arrayOf(
            arrayOf(3, 3).toIntArray(),
            arrayOf(5, -1).toIntArray(),
            arrayOf(-2, 4).toIntArray(),
        ),
        2
    ).forEach {
        println(it.toMutableList())
    }
}

fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
    var distances = ArrayList<Point>()

    points.forEach {
        distances.add(Point(getDisitance(it[0], it[1], 0, 0), it))
    }

    distances.sort()

    return Array<IntArray>(k, { IntArray(2) }).apply {
        for (i in 0 until k) {
            this[i] = (distances[i].array)
        }
    }
}

class Point(
    val distance: Double,
    val array: IntArray
) : Comparable<Point> {
    override fun compareTo(other: Point): Int {
        return distance.compareTo(other.distance).toInt()
    }
}

fun getDisitance(i: Int, i1: Int, i2: Int, i3: Int): Double {
    return Math.sqrt(
        (i - i2).toDouble() * (i - i2).toDouble()
                +
                (i1 - i3).toDouble() * (i1 - i3).toDouble()
    )
}
