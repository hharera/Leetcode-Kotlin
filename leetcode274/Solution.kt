package com.harera.leetcode.leetcode274

import kotlin.math.max

class Solution {
    fun hIndex(citations: IntArray): Int {
        val hashMap = HashMap<Int, Int>()
        citations.forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }
        val commutative = Array<Int>(citations.size + 1) { 0 }
        var max = 0
        hashMap.keys.sortedDescending().forEachIndexed { index, i ->
            commutative[index + 1] = commutative[index] + hashMap[i]!!
            if (commutative[index + 1] >= i)
                max = max(max, i)
            max = max(max, hashMap[i]!!)
        }
        return max
    }
}

fun main() {

}