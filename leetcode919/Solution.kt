package com.harera.leetcode.leetcode919


data class Interval(var start: Int, var end: Int)

class Solution {

    fun minMeetingRooms(intervals: List<Interval>): Int {
        val sortedIntervals = intervals.sortedWith { interval, otherInterval ->
            if (interval!!.start != otherInterval!!.start) {
                interval.start - otherInterval.start
            } else {
                interval.end - otherInterval.end
            }
        }.toMutableList()

        val temp = mutableListOf<Interval>()
        var ans = 0
        var idx = 1
        while (sortedIntervals.isNotEmpty() || temp.isNotEmpty()) {
            if (1 > sortedIntervals.lastIndex) {
                if (temp.isNotEmpty()) {
                    ans++
                    temp.clear()
                }
                if (sortedIntervals.isNotEmpty()) {
                    ans++
                }
                break
            }

            if (sortedIntervals.get(idx).start < sortedIntervals.get(idx - 1).end) {
                temp.add(sortedIntervals[idx - 1])
                sortedIntervals.removeAt(idx - 1)
            }


            if (idx > sortedIntervals.lastIndex) {
                sortedIntervals.clear()
                sortedIntervals.addAll(temp)
                temp.clear()
                sortedIntervals.sortBy { it.start }
                ans++
            }
        }

        return ans
    }
}

fun main() {
    println(Solution().minMeetingRooms(listOf(Interval(0, 30), Interval(31, 35), Interval(0, 30))))
}