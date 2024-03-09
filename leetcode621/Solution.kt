package com.harera.leetcode.leetcode621

class Solution {

    // time = 0
    // taskTime[26]
    // taskFreq[26]
    // sum = tasks.size
    // idx = 0
    // idles = 0
    // while(sum > 0)
    // if idx == 26 : idx = 0
    // if taskFreq[idx] == 0 : idx++ continue
    // if time - taskTime[idx] < n : idles = time - taskTime[idx], time +=
    // sum--
    // taskFreg[idx]--
    // taskTime[idx++] = time++

    fun leastInterval(tasks: CharArray, n: Int): Int {
        if (n == 1) {
            return tasks.size
        }
        val taskTime = IntArray(26)
        val taskFreq = IntArray(26)
        var sum = tasks.size
        var time = 1
        var idx = 0
        var idles = 0
        for (task in tasks) {
            taskFreq[task - 'A']++
        }

        while (sum > 0) {
            if (idx == 26) {
                idx = 0
            }
            if (taskFreq[idx] == 0) {
                idx++
                continue
            }
            if (taskTime[idx] != 0 && time - 1 - taskTime[idx] < n) {
                idles = n - (time - 1 - taskTime[idx])
                time += idles
            }
            sum--
            taskFreq[idx]--
            taskTime[idx++] = time++
        }
        return time - 1
    }
}

fun main() {
    println(Solution().leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 2))
    // ["A","C","A","B","D","B"]
    println(Solution().leastInterval(charArrayOf('A', 'C', 'A', 'B', 'D', 'B'), 1))
}

