package com.harera.leetcode.leetcode937

class Solution {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        logs.map {
            val split = it.split(" ")
            val id = split[0]
            Log(split[1].first().isDigit(), id, it.substring(id.length + 1))
        }.sorted().let {
            return it.map { it.id + ' ' + it.content }.toTypedArray()
        }
    }

    class Log(val isDigit: Boolean, val id: String, val content: String) : Comparable<Log> {
        override fun compareTo(other: Log): Int {
            if (isDigit && other.isDigit) {
                return 0
            }
            if (isDigit) {
                return 1
            }
            if (other.isDigit) {
                return -1
            }
            if (content == other.content) {
                return id.compareTo(other.id)
            }
            return content.compareTo(other.content)
        }
    }
}