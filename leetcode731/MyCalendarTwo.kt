package com.harera.leetcode.leetcode731

import kotlin.math.max
import kotlin.math.min

class MyCalendarTwo() {

    private val intersections = ArrayList<Interval>()
    private val events = ArrayList<Interval>()
    fun book(start: Int, end: Int): Boolean {
        events.add(Interval(start, end))
        events.sort()


        if (events.size > 1) {
            val idx = events.indexOfFirst {
                it.start == start && it.end == end
            }

            if (idx > 0 && start >= events[idx - 1].start && start < events[idx - 1].end) {
                val prev = events[idx - 1]
                val intersection = Interval(max(start, prev.start), min(end, prev.end))
                if (intersections.isEmpty()) {
                    intersections.add(intersection)
                    return true
                }

                val last = intersections.last()
                if (intersection.start >= last.start && intersection.start < last.end) {
                    last.start = min(intersection.start, last.start)
                    last.end = max(intersection.end, last.end)
                    return false
                }
            }

            if (idx < events.lastIndex && end >= events[idx + 1].start && end <= events[idx + 1].end) {
                val prev = events[idx + 1]
                val intersection = Interval(max(start, prev.start), min(end, prev.end))
                if (intersections.isEmpty()) {
                    intersections.add(intersection)
                    return true
                }

                val last = intersections.last()
                if (intersection.start >= last.start && intersection.start < last.end) {
                    last.start = min(intersection.start, last.start)
                    last.end = max(intersection.end, last.end)
                    return false
                }
            }
        }
        return true
    }

    private class Interval(var start: Int, var end: Int) : Comparable<Interval> {
        override fun compareTo(other: Interval): Int {
            if (other.start == start) return end - other.end
            return start - other.start
        }
    }
}


fun main() {
    val myCalendarTwo = MyCalendarTwo()
    // [[],[26,35],[26,32],[25,32],[18,26],[40,45],[19,26],[48,50],[1,6],[46,50],[11,18]]
    println(myCalendarTwo.book(26, 35))
    println(myCalendarTwo.book(26, 32))
    println(myCalendarTwo.book(25, 32))
    println(myCalendarTwo.book(18, 26))
    println(myCalendarTwo.book(40, 45))
    println(myCalendarTwo.book(19, 26))
    println(myCalendarTwo.book(48, 50))
    println(myCalendarTwo.book(1, 6))
}