package LeetCode141

import LeetCode19.ListNode

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
