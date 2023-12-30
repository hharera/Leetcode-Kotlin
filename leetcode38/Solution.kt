package com.harera.leetcode.leetcode38

class Solution {
    fun countAndSay(n: Int): String {
        if (n == 1)
            return "1"

        var result = "1"
        var remaining = n - 1
        while (remaining > 0) {
            var _result = ""
            var start = 0
            var cur = start + 1
            while (cur < result.length) {
                if (result[cur] != result[start]) {
                    _result += "${cur - start}${result[start]}"
                    start = cur
                    cur++
                } else
                    cur++
            }
            _result += "${cur - start}${result[start]}"
            result = _result
            remaining--
        }
        return result
    }
}
// 1
// 11
// 21
// 1211
// 111221
// 312211
// 13112221