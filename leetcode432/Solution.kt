package com.harera.leetcode.leetcode432

import java.util.*
import java.util.AbstractMap.SimpleEntry

class AllOne() {

    private val maxQ = PriorityQueue<Map.Entry<String, Int>> { a, b ->
        b.value - a.value
    }

    private val minQ = PriorityQueue<Map.Entry<String, Int>> { a, b ->
        a.value - b.value
    }
    private val keys = HashMap<String, Int>()
    fun inc(key: String) {
        if (keys[key] != null) {
            keys[key] = keys[key]!! + 1
        } else {
            keys.put(key, 1)
        }
        minQ.add(SimpleEntry(key, keys[key]!!))
        maxQ.add(SimpleEntry(key, keys[key]!!))
    }

    fun dec(key: String) {
        if (keys[key]!! == 1) {
            keys.remove(key)
        } else {
            keys[key] = keys[key]!! - 1
            minQ.add(SimpleEntry(key, keys[key]!!))
            maxQ.add(SimpleEntry(key, keys[key]!!))
        }
    }

    fun getMaxKey(): String {
        if (keys.isEmpty())
            return ""

        var peek = maxQ.peek()
        while (maxQ.isNotEmpty() && peek != null && keys[peek.key] != peek.value) {
            maxQ.poll()
            peek = maxQ.peek()
        }
        if (maxQ.peek() == null)
            return ""
        return maxQ.peek().key
    }

    fun getMinKey(): String {
        if (keys.isEmpty())
            return ""

        var peek = minQ.peek()
        while (minQ.isNotEmpty() && peek != null && keys[peek.key] != peek.value) {
            minQ.poll()
            peek = minQ.peek()
        }
        if (minQ.peek() == null)
            return ""
        return minQ.peek().key
    }
}

fun main() {
    AllOne().apply {
        inc("hello")
        inc("hello")
        println(getMaxKey())
        println(getMinKey())
        inc("leet")
        println(getMaxKey())
        println(getMinKey())
    }
}
