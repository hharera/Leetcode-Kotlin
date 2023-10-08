package com.harera.leetcode.leetcode146

import java.util.*

class LRUCache(val capacity: Int) {

    private val pq = PriorityQueue<CacheItem>()
    private val map = mutableMapOf<Int, Int>()
    private val usage = mutableMapOf<Int, Int>()

    fun get(key: Int): Int {
        var value = -1
        if (map.containsKey(key)) {
            value = map[key]!!
        }

        val newUsage = (usage[key] ?: 0) + 1
        usage[key] = newUsage

        if (pq.isNotEmpty()) {
            val poll = pq.poll()
            if (poll.key == key) {
                pq.add(CacheItem(key, value, newUsage))
            } else {
                pq.add(poll)
                pq.add(CacheItem(key, value, newUsage))
            }
        }

        return value
    }

    fun put(key: Int, value: Int) {
        if (map.size >= capacity) {
            var poll = pq.poll()
            while (poll != null) {
                if (map.containsKey(poll.key).not())
                    poll = pq.poll()
                if(usage[poll.key] != poll.usage)
                    poll = pq.poll()
                else
                    break
            }
            map.remove(poll.key)
            usage.remove(poll.key)
        }

        val newUsage = (usage[key] ?: 0) + 1
        map[key] = value
        usage[key] = newUsage
        pq.add(CacheItem(key, value, newUsage))
    }

    private data class CacheItem(
        val key: Int,
        val value: Int,
        val usage: Int,
    ) : Comparable<CacheItem> {
        override fun compareTo(other: CacheItem): Int {
            return usage - other.usage
        }
    }

}

fun main() {
    val cache = LRUCache(2 /* capacity */)
    cache.put(1, 1)
    cache.put(2, 2)
    println(cache.get(1)) // returns 1
    cache.put(3, 3) // evicts key 2
    println(cache.get(2)) // returns -1 (not found)
    cache.put(4, 4) // evicts key 1
    println(cache.get(1)) // returns -1 (not found)
    println(cache.get(3)) // returns 3
    println(cache.get(4)) // returns 4
}