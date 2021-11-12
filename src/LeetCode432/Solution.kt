package LeetCode432

import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap


fun main() {
    AllOne().apply {
        inc("leet")
        inc("hello")
        inc("hello")
        dec("hello")
        dec("hello")
        println(getMaxKey())
        println(getMinKey())
    }
}


data class Key(
    val key: String,
    val count: Int
)

data class Node(
    val key: String,
    var value: Int,
    var next: Node? = null,
    var prev: Node? = null,
)

class AllOne() {
    private var max : Node? = null
    private var min : Node? = null

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

    fun getMaxKey(): String {
        if (max == null)
            return ""

        return max!!.key
    }

    fun getMinKey(): String {
        if (min == null)
            return ""

        return min!!.key
    }

    private fun updateMinMax(key: String, count: Int) {
        if (max == null && min == null) {
            max = Node(key = key, value = count)
            min = Node(key = key, value = count)
            return
        }

        if (max!!.value <= count) {
            max!!.next = Node(key = key, value = count)
            max!!.next!!.prev = max
            max = max!!.next!!
        }

        if (min!!.value >= count) {
            min!!.next = Node(key = key, value = count)
            min!!.next!!.prev = min
            min = min!!.next!!
        }
    }
}