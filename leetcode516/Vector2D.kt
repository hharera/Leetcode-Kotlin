package com.harera.leetcode.leetcode516

import kotlin.math.max


class Solution {

    private val visited = HashMap<String, Int>()

    fun longestPalindromeSubseq(s: String): Int {
        return solve(s, idx = 0)
    }

    private fun solve(s: String, idx: Int): Int {
        if (idx > s.lastIndex) {
            if (isPalindrom(s)) {
                return s.length
            }
            return 0
        }

        if (visited.contains(s)) {
            return visited[s]!!
        }

        return max(solve(s, idx + 1), solve(s.substring(0, idx) + s.substring(idx + 1, s.length), idx)).also {
            visited[s] = it
        }
    }

    private fun isPalindrom(s: String): Boolean {
        var start = 0
        var end = s.lastIndex
        while (start <= end) {
            if (s[start] != s[end])
                return false
            start++
            end--
        }
        return true
    }
}

fun main() {
    println(Solution().longestPalindromeSubseq("euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew"))
}