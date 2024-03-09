package com.harera.leetcode.leetcode253

import java.util.*

class Interval(var start: Int, var end: Int)

class Solution {
    private val queue = PriorityQueue<Int>()
    fun minMeetingRooms(_intervals: List<Interval>): Int {
        val intervals = _intervals.sortedBy { it.start }
        for (interval in intervals) {
            if (queue.isNotEmpty() && queue.peek() <= interval.start) {
                queue.poll()
            }
            queue.add(interval.end)
        }
        return queue.size
    }
}
