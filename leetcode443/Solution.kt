package com.harera.leetcode.leetcode443

class Solution {
    fun compress(chars: CharArray): Int {
        var readingIdx = 0
        var writingIdx = 0
        var result = 0
        while (readingIdx < chars.size) {
            val char = chars[readingIdx]
            val count = count(chars, readingIdx)
            "$char$count".also {
                if (count > 1) {
                    it.forEachIndexed { index, c ->
                        chars[writingIdx + index] = c
                    }
                    result += it.length
                    writingIdx += it.length
                } else {
                    chars[writingIdx] = char
                    result++
                    writingIdx++
                }
                readingIdx += count
            }
        }
        return result
    }

    private fun count(chars: CharArray, _idx: Int): Int {
        var count = 0
        var idx = _idx
        while (idx < chars.size && chars[idx++] == chars[_idx])
            count++
        return count
    }
}

fun main() {
    charArrayOf('a','a','a','a','a','b').also {
        println(Solution().compress(it))
        println(it.contentToString())
    }


    charArrayOf('a', 'a', 'a', 'a', 'b', 'b', 'a', 'a').also {
        println(Solution().compress(it))
        println(it.contentToString())
    }
}