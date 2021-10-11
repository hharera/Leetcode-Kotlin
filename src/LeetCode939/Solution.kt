package LeetCode939

fun main() {

}

fun minAreaRect(points: Array<IntArray>): Int {
    val lines = HashMap<Pair<Int, Int>, Int>()
    for (i in points.indices) {
        for (j in points.indices) {
            if (i == j)
                continue

            if (points[j][1] - points[i][1] != 0)
                continue

            if (points[j][0] < points[i][0])
                lines.put(
                    Pair(points[j][0], points[i][0]),
                    lines.getOrDefault(Pair(points[j][0], points[i][0]), -1) + 1
                )
            else
                lines.put(
                    Pair(points[i][0], points[j][0]),
                    lines.getOrDefault(Pair(points[i][0], points[j][0]), -1) + 1
                )
        }
    }

    var ans = 0
    lines.values.forEach {
        ans += ncr(it, 2)
    }
    return ans
}

fun ncr(n: Int, r: Int): Int {
    return fact(n) / (fact(r) *
            fact(n - r))
}

fun fact(n: Int): Int {
    var res = 1
    for (i in 2..n) res = res * i
    return res
}
