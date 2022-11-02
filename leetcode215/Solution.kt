package LeetCode215

fun main() {


}

fun findKthLargest(nums: IntArray, k: Int): Int =
    nums.sorted()[nums.size-k]
