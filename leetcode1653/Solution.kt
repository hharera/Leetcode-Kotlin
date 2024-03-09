//package com.harera.leetcode.leetcode1653
//
//class Solution {
//
//    private val visited = HashMap<String, Int>()
//    fun minimumDeletions(s: String): Int {
//        if (s.toSet().size == 1) {
//            return 0
//        }
//        return solve(s, idx = 0, a = 0, b = 0)
//    }
//
//    private fun solve(s: String, idx: Int, a: Int, b: Int): Int {
//        if (idx > s.lastIndex) {
//            return 0
//        }
//
//        if (visited.contains(s)) {
//            return visited[s]!!
//        }
//
//        var min = Int.MAX_VALUE
//        if (s[idx] == 'a') {
//            if (b == 0) {
//                min = minOf(min, solve(s, idx + 1, a + 1, b))
//            } else {
//                s[idx] = 'b'
//                min = minOf(min, solve(s, idx + 1, a, b - 1) + 1)
//            }
//        } else {
//            if (a == 0) {
//                min = minOf(min, solve(s, idx + 1, a, b) + 1)
//            } else {
//                min = minOf(min,solve(s, idx + 1, a, b + 1))
//                if (b == 0) {
//                    min = minOf(min, solve(s, idx + 1, a - 1, b) + 1)
//                }
//            }
//        }
//
//        return min.also {
//            visited["$idx $a $b"] = it
//        }
//    }
//}