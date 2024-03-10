package com.harera.leetcode.leetcode767

class Solution {
    private val chars = MutableList(26) { CharCount('a' + it, 0) }
    fun reorganizeString(s: String): String {
        if (s.length < 2) {
            return s
        }
        s.forEach {
            chars[it - 'a'].count++
        }
        chars.sort()
        var i = 0
        var j = 25
        var sb = StringBuilder()
        while (i < j) {
            if (chars[i].count == 0) {
                i++
                continue
            }
            if (chars[j].count == 0) {
                j--
                continue
            }
            if (chars[i].count > chars[j].count) {
                sb.append(chars[i].char)
                sb.append(chars[j].char)
                chars[i].count--
                chars[j].count--
            } else {
                sb.append(chars[j].char)
                sb.append(chars[i].char)
                chars[i].count--
                chars[j].count--
            }
        }
        var remaining = chars[i].count
        var char = chars[i].char
        var idx = 1
        while (remaining > 0 && idx < sb.length) {
            if (sb[idx] != char && sb[idx - 1] != char) {
                sb.insert(idx, char)
                remaining--
                idx += 2
            } else if (idx == sb.lastIndex && sb[idx] != char) {
                sb.append(char)
                remaining--
            } else {
                idx++
            }
        }
        if (remaining > 0) {
            return ""
        }
        return sb.toString()
    }

    class CharCount(val char: Char, var count: Int) : Comparable<CharCount> {
        override fun compareTo(other: CharCount): Int {
            return other.count - count
        }
    }
}

fun main() {
    println(Solution().reorganizeString("aab"))
//    println(Solution().reorganizeString("aaab"))
    println(Solution().reorganizeString("ogccckcwmbmxtsbmozli"))
}