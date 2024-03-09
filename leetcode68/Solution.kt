package com.harera.leetcode.leetcode68

class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val lines = mutableListOf<String>()
        var line = words[0]
        var remaining = maxWidth - words[0].length
        for (i in 1 until words.size) {
            if (remaining == maxWidth) {
                line = words[i]
                remaining -= words[i].length
                continue
            }

            if (words[i].length + 1 <= remaining) {
                line += " ${words[i]}"
                remaining -= words[i].length + 1
            } else {
                lines.add(line)
                line = words[i]
                remaining = maxWidth - words[i].length
            }
        }

        if (line.isNotEmpty()) {
            lines.add(line)
        }
        return lines.map {
            it
            line = it
            if (it.length < maxWidth) {
                val words = line.split(" ")
                var spaces = maxWidth - line.length
                while (spaces > 0) {
                    for (i in 0 until words.lastIndex) {
                        line = line.replace(words[i], "${words[i]} ")
                        spaces--
                        if (spaces == 0)
                            break
                    }
                }
            }
            line
        }
    }
}

fun main() {
    println(Solution().fullJustify(arrayOf("This", "is", "an", "example", "of", "text", "justification."), 16))

    println(Solution().fullJustify(arrayOf("What", "must", "be", "acknowledgment", "shall", "be"), 16))

    println(
        Solution().fullJustify(
            arrayOf(
                "Science",
                "is",
                "what",
                "we",
                "understand",
                "well",
                "enough",
                "to",
                "explain",
                "to",
                "a",
                "computer.",
                "Art",
                "is",
                "everything",
                "else",
                "we",
                "do"
            ), 20
        )
    )
}