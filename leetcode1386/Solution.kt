package com.harera.leetcode.leetcode1386

class Solution {

    fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
        val isReserved = HashMap<Int, Array<Boolean>>()
        reservedSeats.forEach { seat ->
            val row = seat.first()
            val col = seat.last()
            if (!isReserved.contains(row))
                isReserved.set(row, Array(11) { false })
            isReserved[row]!![col] = true;
        }
        var ans = (n - isReserved.keys.size) * 2
        isReserved.keys.forEach { row ->
            var groups = 0
            for (col in 2..5) {
                if (isReserved[row]!![col])
                    break
                if (col == 5)
                    groups++
            }
            for (col in 6..9) {
                if (isReserved[row]!![col])
                    break
                if (col == 9)
                    groups++
            }
            if (groups == 0)
                for (col in 4..7) {
                    if (isReserved[row]!![col])
                        break
                    if (col == 7)
                        groups++
                }
            ans += groups
        }
        return ans
    }
}

fun main() {
    println(
        Solution().maxNumberOfFamilies(
            3,
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(1, 3),
                intArrayOf(1, 8),
                intArrayOf(2, 6),
                intArrayOf(3, 1),
                intArrayOf(3, 10)
            )
        )
    )

    println(
        Solution().maxNumberOfFamilies(
            2,
            arrayOf(
                intArrayOf(2, 1),
                intArrayOf(1, 8),
                intArrayOf(2, 6)
            )
        )
    )

    println(
        Solution().maxNumberOfFamilies(
            4,
            arrayOf(
                intArrayOf(4, 3),
                intArrayOf(1, 4),
                intArrayOf(4, 6),
                intArrayOf(1, 7)
            )
        )
    )
}
