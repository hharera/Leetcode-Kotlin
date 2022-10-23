package LeetCode1299

internal class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        for (i in 0 until arr.size - 1) {
            var bigest = arr[i + 1]
            for (j in i + 2 until arr.size) {
                if (arr[j] > bigest) {
                    bigest = arr[j]
                }
            }
            arr[i] = bigest
        }
        arr[arr.size - 1] = -1
        return arr
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = intArrayOf(17, 18, 5, 4, 6, 1)
            Solution().replaceElements(arr)
            for (i in arr) {
                println(i)
            }
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