package LeetCode414

fun main() {

}

fun thirdMax(nums: IntArray): Int {
    val set = HashSet<Int>()

    nums.forEach {
        set.add(it)
    }

    if(set.size >= 3)
        return set.toIntArray().sortedDescending().get(2)
    else
        return set.toIntArray().sortedDescending().last()
}