package LeetCode1313

class Solution {
    fun decompressRLElist(nums: IntArray): IntArray {
        val list: MutableList<Int> = arrayListOf()
        run {
            var i = 0
            while (i < nums.size) {
                for (j in 0 until nums[i]) {
                    list.add(nums[i + 1])
                }
                i += 2
            }
        }
        val ans = IntArray(list.size)
        for (i in ans.indices) {
            ans[i] = list[i]!!
        }
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = intArrayOf(1, 1, 2, 3)
            val ans = Solution().decompressRLElist(arr)
            for (i in ans) {
                println(i)
            }
        }
    }



    internal class ListNode {
        var `val` = 0
        var next: ListNode? = null

        constructor() {}
        constructor(`val`: Int) {
            this.`val` = `val`
        }

        constructor(`val`: Int, next: ListNode?) {
            this.`val` = `val`
            this.next = next
        }
    }
}