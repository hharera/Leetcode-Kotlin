package com.harera.leetcode.leetcode739

class Solution {
//    fun dailyTemperatures(temperatures: IntArray): IntArray {
//        val mat = Array<ArrayList<Int>>(105, { ArrayList() })
//        temperatures.forEachIndexed { idx, value ->
//            mat[value].add(idx)
//        }
//
//        val answer = IntArray(temperatures.size).apply {
//            fill(Int.MAX_VALUE)
//        }
//        temperatures.forEachIndexed { idx, _temp ->
//            for (temp in _temp + 1..100) {
//                var start = 0
//                var end = mat[temp].lastIndex
//
//                while (start < end) {
//                    var mid = (start + end) / 2
//
//                    if (mat[temp][mid] > idx) {
//                        end = mid
//                    } else {
//                        start = mid + 1
//                    }
//                }
//
//                if (start <= mat[temp].lastIndex && mat[temp][start] > idx)
//                    answer[idx] = if (answer[idx] > mat[temp][start] - idx)
//                        mat[temp][start] - idx
//                    else
//                        answer[idx]
//            }
//        }
//        return answer.map {
//            if (it == Int.MAX_VALUE)
//                0
//            else
//                it
//        }.toIntArray()
//    }

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val days = ArrayList<Day>()
        val dayIndex = Array<Int>(temperatures.size) { 0 }
        temperatures.forEachIndexed { index, temperature ->
            days.add(Day(index, temperature))
        }
        days.sort()
        days.forEachIndexed { index, day ->
            dayIndex[day.idx] = index
        }
        val answer = IntArray(temperatures.size)
        temperatures.forEachIndexed { index, it ->
            var left = 0
            var right = temperatures.lastIndex
            var mid = (left + right) / 2
            while (left < right) {
                mid = (left + right) / 2
                if (days[mid].temperature < temperatures[mid]) {
                    right = mid
                } else if (days[mid].temperature == temperatures[mid]) {
                    right = mid - 1
                } else {
                    left = mid
                }
            }
            if (days[dayIndex[mid]].idx > index) {
                answer[index] = days[dayIndex[mid]].idx - it
            }
        }
        return answer
    }
}

data class Day(
    val idx: Int,
    val temperature: Int
) : Comparable<Day> {
    override fun compareTo(other: Day): Int {
        if (temperature == other.temperature)
            return idx - other.idx
        return other.temperature - temperature
    }

}

fun main() {
    val solution = Solution()
    solution.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)).let {
        println(it.toMutableList())
    }
}
