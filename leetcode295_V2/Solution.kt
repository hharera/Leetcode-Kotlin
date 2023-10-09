package com.harera.leetcode.leetcode295_V2

import java.util.*


class MedianFinder() {

    var lastMedian: Double = -1.0
    var lastMedianIdx = -1
    val list = mutableListOf<Int>()

    val minQueue = PriorityQueue<Int>(Collections.reverseOrder())
    val maxQueue = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (maxQueue.isEmpty()) {
            maxQueue.add(num)
            return
        }
        if (minQueue.isEmpty()) {
            minQueue.add(num)
            return
        }
        if (minQueue.peek() > num) {
            minQueue.add(num)
        } else {
            maxQueue.add(num)
        }
        if (minQueue.peek() > maxQueue.peek()) {
            val max = minQueue.poll()
            val min = maxQueue.poll()
            minQueue.add(min)
            maxQueue.add(max)
        }
    }

    fun findMedian(): Double {
        return lastMedian
    }
}


fun main() {
    //["MedianFinder","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian","addNum","findMedian"]
    //[[],[6],[],[10],[],[2],[],[6],[],[5],[],[0],[],[6],[],[3],[],[1],[],[0],[],[0],[]]
    val medianFinder = MedianFinder()
    medianFinder.addNum(6)
    println(medianFinder.findMedian())
    medianFinder.addNum(10)
    println(medianFinder.findMedian())
    medianFinder.addNum(2)
    println(medianFinder.findMedian())
    medianFinder.addNum(6)
    println(medianFinder.findMedian())
    medianFinder.addNum(5)
    println(medianFinder.findMedian())

}
