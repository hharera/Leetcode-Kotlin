package com.harera.leetcode.leetcode1054


class Solution {
    fun rearrangeBarcodes(barcodes: IntArray): IntArray {
        val map = hashMapOf<Int, Int>()
        barcodes.forEach {
            val count = map.getOrPut(it) { 0 }
            map[it] = count + 1
        }

        val result = mutableListOf<Int>()
        val keys = map.keys
        while (map.keys.isNotEmpty()) {
            keys.forEach {
                result.add(it)
                map.put(it, map[it]!! - 1)
                if (map[it] == 0) {
                    map.remove(it)
                }
            }
        }
        return result.toIntArray()
    }
}

fun main() {
    val solution = Solution()
// [1,1,1,2,2,2]
// [1,1,1,1,2,2,3,3]
// [2,2,1,3]
    solution.rearrangeBarcodes(intArrayOf(1, 1, 1, 2, 2, 2)).forEach {
        print("$it ")
    }

    println()

    solution.rearrangeBarcodes(intArrayOf(1, 1, 1, 1, 2, 2, 3, 3)).forEach {
        print("$it ")
    }

}