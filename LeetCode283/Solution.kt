package LeetCode283

import java.util.*

fun moveZeroes(nums: IntArray): Unit {
    val nonZerosQueue: Queue<Int> = LinkedList()

    nums.forEachIndexed { id, num ->
        if (num != 0) {
            nonZerosQueue.add(num)
        }
    }

    for (i in 0..nums.lastIndex) {
        if (nonZerosQueue.isNotEmpty()) {
            nums[i] = nonZerosQueue.poll()
        } else {
            nums[i] = 0
        }
    }
}

fun main() {
    val nums = arrayOf(
        0, 1, 0, 3, 12
    ).toIntArray()

    moveZeroes(nums)
    nums.forEach {
        print(
            "$it "
        )
    }
}