package LeetCode18

import LeetCode15.threeSum

fun main() {
    println(
        fourSum(
            arrayOf(
                2,2,2,2,2
            ).toIntArray(), 8
        ).toString()
    )
}

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    nums.sort()

    val numsSet = HashMap<Int, Int>()
    nums.forEachIndexed { idx, v ->
        numsSet.put(v, idx)
    }

    val ans = arrayListOf<List<Int>>()
    val visited = HashSet<String>()
    for (i in nums.indices) {
        for (j in nums.indices) {
            for (k in nums.indices) {
                if (i != j && j != k && i != k) {
                    var sum = nums[i] + nums[j] + nums[k]
                    var remine = target - sum
                    if (
                        numsSet.contains(remine) && numsSet.get(remine) != i
                        && numsSet.get(remine) != j
                        && numsSet.get(remine) != k
                    ) {
                        arrayListOf<Int>().apply {
                            add(nums[i])
                            add(nums[j])
                            add(nums[k])
                            add(remine)
                            sort()
                        }.toString().let {
                            if (!visited.contains(it)) {
                                ans.add(arrayOf(nums[i], nums[j],nums[k], remine).toList())
                                visited.add(it)
                            }
                        }
                    }
                }
            }
        }
    }
    return ans
}