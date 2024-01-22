package com.harera.leetcode.leetcode726

import java.util.*

class Solution {
    fun countOfAtoms(formula: String): String {
        val freqStack = LinkedList<Int>()
        val closeStack = LinkedList<Int>()
        val openStack = Stack<Int>()

        var idx = 0
        while (idx < formula.length) {
            val it = formula[idx]
            if (it == '(')
                openStack.push(idx)
            if (it == ')') {
                closeStack.push(idx)
                if(idx >= formula.lastIndex || !formula[idx + 1].isDigit())
                    freqStack.push(1)
            }
            if (it.isDigit()) {
                var freq = ""
                while (idx < formula.length && formula[idx].isDigit())
                    freq += formula[idx++]
                idx--
                freqStack.push(freq.toInt())
            }
            idx++
        }
        throw Exception()
    }
}

fun main() {
    println(Solution().countOfAtoms(formula = "H2O"))
    println(Solution().countOfAtoms(formula = "Mg(OH)2"))
    println(Solution().countOfAtoms(formula = "K4(ON(SO3)2)2"))
    println(Solution().countOfAtoms(formula = "Be32"))
}