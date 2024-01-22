package com.harera.leetcode.leetcode833

import java.util.*
import kotlin.math.min

class Solution {
    fun findReplaceString(s: String, indices: IntArray, sources: Array<String>, targets: Array<String>): String {
        val chars = s.toCharArray()
        val validReplacements = LinkedList<Replacement>()

        val replacements = indices.mapIndexed { idx, _ ->
            createReplacement(indices[idx], sources[idx], targets[idx])
        }.sorted()

        for (replacement in replacements) {
            val original = s.substring(min(replacement.start + 1, s.length), min(replacement.end + 1, s.length))
            if (original == replacement.source) {
                validReplacements.add(replacement)
                chars[replacement.start] = '0'
            }
        }
        var result = ""
        var char = 0
        while (char < chars.size) {
            if (chars[char] == '0') {
                char = validReplacements.peek().end + 1
                result += validReplacements.pop().target
            } else {
                result += chars[char]
                char++
            }
        }
        return result
    }

    private fun createReplacement(
        idx: Int,
        source: String,
        target: String
    ): Replacement {
        return Replacement(
            start = idx,
            end = idx + source.length - 1,
            source = source,
            target = target
        )
    }

    data class Replacement(
        val start: Int,
        val end: Int,
        val source: String,
        val target: String
    ) : Comparable<Replacement> {
        override fun compareTo(other: Replacement): Int {
            return start.compareTo(other.start)
        }
    }
}

fun main() {
    val solution = Solution()
    //"vmokgggqzp"
    //[3,5,1]
    //["kg","ggq","mo"]
    //["s","so","bfr"]
    println(
        solution.findReplaceString(
            "vmokgggqzp",
            intArrayOf(3, 5, 1),
            arrayOf("kg", "ggq", "mo"),
            arrayOf("s", "so", "bfr")
        )
    )
}
