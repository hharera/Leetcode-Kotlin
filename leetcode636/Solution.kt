package LeetCode636

import java.util.*

fun main() {
    println(
        exclusiveTime(
            2,
            arrayListOf("0:start:0", "1:start:2", "1:end:5", "0:end:6")
        ).toMutableList()
    )
}

fun exclusiveTime(n: Int, logs: List<String>): IntArray {
    val logsList = arrayListOf<Log>()

    logs.forEach {
        val log = it.split(":")
        logsList.add(Log(log[0].toInt(), log[1], log[2].toInt()))
    }
    logsList.sort()

    val funs = IntArray(n)
    val stack = Stack<Log>()

    logsList.forEach { logSecond ->
        if (logSecond.op == "start")
            stack.add(logSecond)
        else {
            val logFirst = stack.pop()
            val period = logSecond.time - logFirst.time + 1
            funs[logFirst.funId] += period
            stack.forEach {
                funs[it.funId] -= period
            }
        }
    }

    return funs
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
