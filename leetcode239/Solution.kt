package LeetCode239

import java.util.*

fun main() {

    println(
        maxSlidingWindow(
            arrayOf(
                1,3,1,2,0,5
            ).toIntArray(),
            3
        ).toMutableList()
    )
}

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val pq = PriorityQueue<Int>(
        object : Comparator<Int> {
            override fun compare(o1: Int, o2: Int): Int {
                return o2 - o1
            }
        }
    )

    val hm = HashMap<Int, Int>()
    val ans = ArrayList<Int>()

    var idx = 0
    while (idx < k) {
        if (hm.containsKey(nums[idx]))
            hm.put(nums[idx], hm[nums[idx]]!! + 1)
        else
            hm.put(nums[idx], 1)
        pq.add(nums[idx])
        idx++
    }
    ans.add(pq.poll())

    while (idx < nums.size) {
        pq.clear()

        if (hm[nums[idx - k]]!! > 1)
            hm.put(nums[idx - k], hm[nums[idx - k]]!! - 1)
        else
            hm.remove(nums[idx - k])

        if (hm.containsKey(nums[idx]))
            hm.put(nums[idx], hm[nums[idx]]!! + 1)
        else
            hm.put(nums[idx], 1)

        pq.addAll(hm.keys)
        ans.add(pq.poll())
        idx++
    }
    return ans.toIntArray()
}