package LeetCode380

import java.util.*
import kotlin.collections.HashSet

fun main() {
    RandomizedSet().apply {
        println(insert(1))
        println(insert(2))
        println(insert(3))
        println(insert(4))
        println(remove(1))
        println(getRandom())
        println(getRandom())
        println(remove(2))
        println(getRandom())
        println(remove(3))
        println(getRandom())
        println(getRandom())
    }
}

class RandomizedSet() {
    val set = HashSet<Int>()
    var idx = 0

    fun insert(`val`: Int): Boolean =
        !set.contains(`val`).also {
            set.add(`val`)
        }

    fun remove(`val`: Int): Boolean =
        set.contains(`val`).also {
            set.remove(`val`)
        }

    fun getRandom(): Int =
        set.toIntArray()[idx % set.size].also {
            idx = (idx + 3) % set.size
        }
}