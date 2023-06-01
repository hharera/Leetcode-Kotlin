package com.harera.leetcode.leetcode299


class Solution {

    fun getHint(secret: String, guess: String): String {
        val secretSet = ArrayList<Char>()
        val guessSet = ArrayList<Char>()

        var bullCount = 0
        var cowsCount = 0
        for (idx in secret.indices) {
            if (secret[idx] == guess[idx]) {
                bullCount++
            } else {
                secretSet.add(secret[idx])
                guessSet.add(guess[idx])
            }
        }

        secretSet.forEachIndexed { index, it ->
            val indexOf = guessSet.indexOf(it)
            if (indexOf != -1) {
                cowsCount++
                guessSet.removeAt(indexOf)
            }
        }
        return "${bullCount}A${cowsCount}B"
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    println(solution.getHint("1807", "7810"))
}
