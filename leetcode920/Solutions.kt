package com.harera.leetcode.leetcode920


data class Interval(var start: Int, var end: Int)

class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        val intervalList = intervals.sortedWith { o1, o2 ->
            if (o1!!.start != o2!!.start) {
                o1.start - o2.start
            } else {
                o1.end - o2.end
            }
        }

        for (i in 1..intervalList.lastIndex) {
            if (intervalList[i].start < intervalList[i - 1].end) {
                return false
            }
        }

        return true
    }
}

fun main() {
    println(Solution().canAttendMeetings(listOf(Interval(0, 30), Interval(5, 10), Interval(15, 20))))
}