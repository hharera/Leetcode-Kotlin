/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode771

/**
 *
 * @author harera
 */
internal class Solution {
    fun numJewelsInStones(J: String, S: String): Int {
        val chars: MutableMap<Char?, Int?> = HashMap()
        for (i in 0 until J.length) {
            chars[J[i]] = 1
        }
        var ans = 0
        for (i in 0 until S.length) {
            if (chars.containsKey(S[i])) {
                ans++
            }
        }
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution().numJewelsInStones("z", "ZZ"))
        }
    }
}