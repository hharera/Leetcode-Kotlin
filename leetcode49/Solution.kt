package com.harera.leetcode.leetcode49

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, List<String>>()
        strs.forEach {
            val string = it.toList().sorted().toString()
            if (map.containsKey(string)) {
                val list = map[string]!!
                map[string] = list + it
            } else {
                map[string] = listOf(it)
            }
        }
        return map.map {
            it.value
        }
    }
}

fun main() {
    val solution = Solution()
//    [["dgggggggggg"],["ddddddddddg"]]
    println(solution.groupAnagrams(arrayOf("ddddddddddg", "dgggggggggg")))
}