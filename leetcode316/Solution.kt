package com.harera.leetcode.leetcode316

class Solution {
    fun removeDuplicateLetters(s: String): String {
        return s.toSet().sorted().joinToString().replace(", ", "")
    }
}