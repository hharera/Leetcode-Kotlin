package com.harera.leetcode.microsoft.problem_1

fun countSubstringsContainingAllDigits(s: String): Int {
    val answers = HashMap<Int, Int>()
    var shortest = Int.MAX_VALUE
    for(i in s.indices) {
        val set = HashSet<Char>()
        for(j in i until s.length) {
            set.add(s[j])
            if(set.size == 10 && j - i + 1 <= shortest) {
                shortest = j - i + 1
                answers[shortest] = (answers[shortest] ?: 0) + 1
            }
        }
    }
    return answers[shortest]!!
}