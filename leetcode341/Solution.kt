package com.harera.leetcode.leetcode341

import java.util.*

interface NestedInteger {
    fun isInteger(): Boolean
    fun getInteger(): Int?
    fun setInteger(value: Int): Unit
    fun add(ni: NestedInteger): Unit
    fun getList(): List<NestedInteger>?
}


class NestedIterator(nestedList: List<NestedInteger>) {

    private val list = LinkedList<Int>()

    init {
        nestedList.forEach {
            flatten(it)
        }
    }

    private fun flatten(it: NestedInteger) {
        if (it.isInteger()) {
            list.add(it.getInteger()!!)
            return
        }
        it.getList()?.forEach {
            flatten(it)
        }
    }

    fun next(): Int {
        return list.pop()
    }

    fun hasNext(): Boolean {
        return list.isNotEmpty()
    }
}
