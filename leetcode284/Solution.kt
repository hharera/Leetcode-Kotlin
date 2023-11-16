package com.harera.leetcode.leetcode284

class PeekingIterator(iterator: Iterator<Int>) : Iterator<Int> {

    private val list = mutableListOf<Int>()
    private var idx = 0

    init {
        iterator.forEach {
            list.add(it)
        }
    }

    fun peek(): Int {
        return list[idx]
    }

    override fun next(): Int {
        return list[idx++]
    }

    override fun hasNext(): Boolean {
        return idx < list.size
    }
}

fun main() {
    val peekingIterator = PeekingIterator(listOf(1, 2, 3).iterator())
    println(peekingIterator.next())
    println(peekingIterator.peek())
    println(peekingIterator.next())
    println(peekingIterator.next())
    println(peekingIterator.hasNext())
}