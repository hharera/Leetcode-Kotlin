package com.harera.leetcode.leetcode251


class Vector2D(vec2d: List<List<Int?>?>?) : MutableIterator<Int?> {

    private var list: MutableList<Int> = mutableListOf()
    private var index: Int = 0

    init {
        vec2d?.forEach {
            it?.forEach {
                it?.let { it1 -> list.add(it1) }
            }
        }
    }

    override fun next(): Int {
        return list.get(index++)
    }

    override fun hasNext(): Boolean {
        if (index >= list.size)
            return false
        return true
    }

    override fun remove() {}
}


fun main() {
    val vec2d = Vector2D(listOf(listOf(1, 2), listOf(3), listOf(4, 5, 6)))
    while (vec2d.hasNext()) {
        println(vec2d.next())
    }
}