package LeetCode141

class LeetCode141 {
    class ListNode {
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

    fun main() {
        val root = ListNode(1)
        println(
            hasCycle(
                ListNode(4).apply {
                    next = root.apply {
                        next = ListNode(3).apply {
                            next = ListNode(2).apply {
                                next = root
                            }
                        }
                    }
                }
            )
        )
    }

    fun hasCycle(head: ListNode?): Boolean {
        if (head == null)
            return false

        if (head.next == null)
            return false

        var fast = head
        var slow = head

        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                return true
            }
        }

        return false
    }
}