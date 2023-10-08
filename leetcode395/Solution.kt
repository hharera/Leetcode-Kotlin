package com.harera.leetcode.leetcode395


class Solution {
    fun longestSubstring(s: String, k: Int): Int {
        val set = s.groupBy {
            it
        }

        var answer = 0
        for (code in 'a'.toInt()..'z'.toInt()) {
            val char = code.toChar()
            if(set.containsKey(char) && set.get(char)!!.size >= k) {
                answer += set[char]!!.size
            }
        }
        return answer
    }
}


fun main() {
    println(Solution().longestSubstring("ababbc", 2))
}