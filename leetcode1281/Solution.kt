package LeetCode1281

internal class Solution {
    fun subtractProductAndSum(n: Int): Int {
        val N = n.toString() + ""
        var product: Long = 1
        var sum = 0
        for (i in 0 until N.length) {
            val cur = (N[i].toString() + "").toInt()
            product *= cur.toLong()
            sum += cur
        }
        return (product - sum).toInt()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(Solution().subtractProductAndSum(111))
        }
    }
}