package LeetCode1290


internal class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        var head = head
        var s = ""
        while (head != null) {
            s += head.`val`
            head = head.next
        }
        val len = s.length
        var ans = 0
        for (i in 0 until len) {
            ans += (Math.pow(2.0, (len - i - 1).toDouble()) * (s[i].toString() + "").toInt()).toInt()
        }
        return ans
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val h = ListNode(1)
            h.next = ListNode(0)
            h.next!!.next = ListNode(1)
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