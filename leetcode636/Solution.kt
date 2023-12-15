package com.harera.leetcode.leetcode636

import java.util.*
import kotlin.math.min

class Solution {
    fun exclusiveTime(n: Int, logs: List<String>): IntArray {
        val funs = Array(n) { Stack<Int>() }

        val result = IntArray(n)
        var lastTime = 0
        for (log in logs) {
            val cur = createLog(log)
            if (cur.op == "start")
                funs[cur.funId].push(cur.time)
            else {
                if (funs[cur.funId].size == 1) {
                    val prev = funs[cur.funId].pop()
                    result[cur.funId] += min(cur.time - lastTime, cur.time - prev) + 1
                    lastTime = prev
                } else {
                    funs[cur.funId].pop()
                }
            }
        }

        return result
    }

    fun createLog(s: String): Log {
        val log = s.split(":")
        return (Log(log[0].toInt(), log[1], log[2].toInt()))
    }

    data class Log(
        val funId: Int,
        val op: String,
        val time: Int,
    ) : Comparable<Log> {
        override fun compareTo(other: Log): Int {
            return time - other.time
        }

    }
}

fun main() {
}
