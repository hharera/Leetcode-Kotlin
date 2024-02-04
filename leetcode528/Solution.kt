package com.harera.leetcode.leetcode528

import java.util.*


class Solution(val w: IntArray) {

    private var sum = w.sum()
    private val random = Random(0)
    private var _w = w.clone()

    fun init() {
        _w = w.clone()
    }

    fun pickIndex(): Int {
        if (sum == 0)
            init()

        var next = random.nextInt(w.size)
        while (_w[next] == 0)
            next = random.nextInt(w.size)

        _w[next] -= 1
        sum -= 1
        return next
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(w)
 * var param_1 = obj.pickIndex()
 */