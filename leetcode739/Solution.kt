package LeetCode739

fun main() {
    println(
        dailyTemperatures(
            arrayOf(
                73, 74, 75, 71, 69, 72, 76, 73
            ).toIntArray()
        ).toMutableList().toString()
    )
}

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val mat = Array<ArrayList<Int>>(105, { ArrayList() })
    temperatures.forEachIndexed { idx, value ->
        mat[value].add(idx)
    }

    val answer = IntArray(temperatures.size).apply {
        fill(Int.MAX_VALUE)
    }
    temperatures.forEachIndexed { idx, _temp ->
        for (temp in _temp + 1..100) {
            var start = 0
            var end = mat[temp].lastIndex

            while (start < end) {
                var mid = (start + end) / 2

                if (mat[temp][mid] > idx) {
                    end = mid
                } else {
                    start = mid + 1
                }
            }

            if (start <= mat[temp].lastIndex && mat[temp][start] > idx)
                answer[idx] = if (answer[idx] > mat[temp][start] - idx)
                    mat[temp][start] - idx
                else
                    answer[idx]
        }
    }
    return answer.map {
        if (it == Int.MAX_VALUE)
            0
        else
            it
    }.toIntArray()
}


data class Day(
    val idx: Int,
    val temprature: Int
) : Comparable<Day> {

    override fun compareTo(other: Day): Int {
        if (temprature == other.temprature)
            return idx - other.idx
        return temprature - other.temprature
    }
}