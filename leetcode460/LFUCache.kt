package com.harera.leetcode.leetcode460

import java.lang.System.currentTimeMillis
import java.util.*

class LFUCache(val capacity: Int) {

    private val map = mutableMapOf<Int, Int>()
    private val usage = mutableMapOf<Int, Int>()
    private val queue = PriorityQueue<Item>()
    fun get(key: Int): Int {
        if (!map.containsKey(key))
            return -1
        queue.add(Item(usage.getOrDefault(key, 0) + 1, key, currentTimeMillis()))
        usage[key] = usage.getOrDefault(key, 0) + 1
        return map.getOrDefault(key, -1)
    }

    fun put(key: Int, value: Int) {
        if (!map.contains(key)) {
            if (map.size == capacity)
                while (queue.isNotEmpty()) {
                    val item = queue.poll()
                    if (!map.contains(item.key) || usage[item.key] != item.usage)
                        continue
                    map.remove(item.key)
                    usage.remove(item.key)
                    break
                }
        }
        map.put(key, value)
        usage[key] = usage.getOrDefault(key, 0) + 1
        queue.add(Item(usage[key]!!, key, currentTimeMillis()))
    }

    private class Item(val usage: Int, val key: Int, val lastUsage: Long) : Comparable<Item> {
        override fun compareTo(other: Item): Int {
            if (usage == other.usage)
                return lastUsage.compareTo(other.lastUsage)
            return usage.compareTo(other.usage)
        }
    }
}


fun main() {
    val cache = LFUCache(2)
    // ["LFUCache","get","put","get","put","put","get","get"]
    // [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
    println(cache.get(2))
    cache.put(2, 6)
    println(cache.get(1))
    cache.put(1, 5)
    cache.put(1, 2)
    println(cache.get(1))
    println(cache.get(2))
}