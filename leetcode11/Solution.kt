package com.harera.leetcode.leetcode11

class Solution{
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()

        val numsSet = HashMap<Int, Int>()
        nums.forEachIndexed { idx, v ->
            numsSet.put(v, idx)
        }

        val ans = arrayListOf<List<Int>>()
        val visited = HashSet<String>()
        for (i in nums.indices) {
            for (j in nums.indices) {

                if (i != j) {
                    var sum = nums[i] + nums[j]
                    var remine = 0 - sum
                    if (numsSet.contains(remine) && numsSet.get(remine) != i && numsSet.get(remine) != j) {
                        arrayListOf<Int>().apply {
                            add(nums[i])
                            add(nums[j])
                            add(remine)
                            sort()
                        }.toString().let {
                            if (!visited.contains(it)) {
                                ans.add(arrayOf(nums[i], nums[j], remine).toList())
                                visited.add(it)
                            }
                        }
                    }
                }

            }
        }

        return ans
    }
}

fun main() {
    println(
        Solution().threeSum(
            arrayOf(
                -1, 0, 1, 2, -1, -4
            ).toIntArray()
        ).toString()
    )
}