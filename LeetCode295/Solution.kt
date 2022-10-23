package LeetCode295

import java.util.*
import kotlin.random.Random.Default.nextInt

private val small = PriorityQueue(Collections.reverseOrder<Int>())
private val large = PriorityQueue<Int>()
private var largeTurn = true

fun findMedian(): Double {
    return if (largeTurn) (small.peek() + large.peek()) / 2.0 else small.peek().toDouble()
}

fun addNum(num: Int) {
    if (largeTurn) {
        large.offer(num)
        small.offer(large.poll())
    } else {
        small.offer(num)
        large.offer(small.poll())
    }
    largeTurn = !largeTurn
}

fun main(args: Array<String>) {
    for (i in 0..9) {
        addNum(nextInt(1, 31))
        println(findMedian())
    }
}
