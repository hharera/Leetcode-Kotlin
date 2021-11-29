package LeetCode432

import kotlin.collections.HashMap


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


data class Key(
    val key: String,
    val count: Int
)

class AllOne() {
    private val keys = HashMap<String, Int>()

    fun inc(key: String) {
        if (keys[key] != null) {
            keys[key] = keys[key]!! + 1
        } else {
            keys.put(key, 1)
        }
    }

    fun dec(key: String) {
        if (keys[key]!! == 1) {
            keys.remove(key)
        } else {
            keys[key] = keys[key]!! - 1
        }
    }

    fun getMaxKey(): String {
        if (keys.isEmpty())
            return ""

        var max = Int.MIN_VALUE
        var key = ""

        keys.forEach {
            max = if (max < it.value) {
                key = it.key
                it.value
            }
            else
                max
        }
        return key
    }

    fun getMinKey(): String {
        if (keys.isEmpty())
            return ""

        var min = Int.MAX_VALUE
        var key = ""

        keys.forEach {
            min = if (min > it.value) {
                key = it.key
                it.value
            }
            else
                min
        }
        return key
    }
}