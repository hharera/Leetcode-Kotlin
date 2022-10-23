package LeetCode918

fun maxSubarraySumCircular(nums: IntArray): Int {
    var max_global = Int.MIN_VALUE
    var max_local = 0

    nums.forEach {
        max_local += it
        if (max_local > max_global)
            max_global = max_local

        if (max_local < 0)
            max_local = 0
    }

    var minGlobal = Int.MAX_VALUE
    var minLocal = 0
    var sum = 0
    nums.forEach {
        minLocal += it
        sum += it
        if (minGlobal > minLocal)
            minGlobal = minLocal

        if (minLocal > 0)
            minLocal = 0
    }

     if(minGlobal == sum)
         return max_global

    return if(max_global > sum - minGlobal)
        max_global
    else
        sum - minGlobal
}

fun main() {
    println(
        maxSubarraySumCircular(
            arrayOf<Int>(
                1, -2, 3, -2
            ).toIntArray()
        )
    )
}