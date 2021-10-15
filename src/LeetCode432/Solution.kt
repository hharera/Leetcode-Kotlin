package LeetCode432

import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap


fun main() {
    AllOne().apply {
        inc("leet")
        inc("hello")
        inc("hello")
        println(getMaxKey())
        println(getMinKey())
    }
}


data class Key(
    val key: String,
    val count: Int
)

class AllOne() {
    private var minQueue = PriorityQueue<Key>(
        object : Comparator<Key> {
            override fun compare(o1: Key, o2: Key): Int {
                return o1.count - o2.count
            }
        }
    )

    private var maxQueue = PriorityQueue<Key>(
        object : Comparator<Key> {
            override fun compare(o1: Key, o2: Key): Int {
                return o2.count - o1.count
            }
        }
    )

    private val keys = HashMap<String, Int>()
    fun inc(key: String) {
        if (keys[key] != null) {
            keys[key] = keys[key]!! + 1
            updateMinMax(key, keys[key]!!)
        } else {
            keys.put(key, 1)
            updateMinMax(key, 1)
        }
    }

    fun dec(key: String) {
        if (keys[key]!! == 1) {
            keys.remove(key)
            updateMinMax(key, 0)
        } else {
            keys[key] = keys[key]!! - 1

            updateMinMax(key, keys[key]!!)
        }
    }

    private fun updateMinMax(key: String, count: Int) {
        if (count == 0) {
            if (maxQueue.peek().key == key) {
                maxQueue.poll()
            }
            if (minQueue.peek().key == key) {
                minQueue.poll()
            }
            return
        }

        maxQueue.add(Key(key, count))
        minQueue.add(Key(key, count))
    }

    fun getMaxKey(): String {
        if (maxQueue.isEmpty())
            return ""

        return maxQueue.peek().key
    }

    fun getMinKey(): String {
        if (minQueue.isEmpty())
            return ""

        return minQueue.peek().key
    }
}