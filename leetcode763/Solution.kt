package com.harera.leetcode.leetcode763

import java.util.*
import kotlin.math.max

class Solution {
    fun partitionLabels(s: String): List<Int> {
        val answer = mutableListOf<Int>()
        var idx = 0
        while (idx < s.length) {
            val start = idx
            var last = s.lastIndexOf(s[idx])
            val queue: Queue<Char> = s.substring(start, last + 1).toHashSet().also {
                it.remove(s[idx])
            }.let {
                LinkedList(it)
            }

            if (queue.isEmpty())
                idx = last + 1

            var result = last - start + 1
            while (queue.isNotEmpty()) {
                val cur = queue.poll()
                val curStart = last + 1
                val curLast = s.lastIndexOf(cur)
                if (curLast > last) {
                    s.substring(curStart, curLast + 1).toHashSet().also {
                        it.remove(cur)
                        queue.addAll(it)
                    }
                    last = curLast
                    result += curLast - curStart + 1
                }
                idx = max(last, curLast) + 1
            }
            answer.add(result)
        }
        return answer
    }
}

fun main() {
    val solution = Solution()
    solution.partitionLabels("caedbdedda").also {
        println(it)
    }
}