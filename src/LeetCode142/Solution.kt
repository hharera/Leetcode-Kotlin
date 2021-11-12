package LeetCode142

import LeetCode19.ListNode

fun main() {
    val root = ListNode(1)
    println(
        detectCycle(
            ListNode(4).apply {
                next = root.apply {
                    next = ListNode(3).apply {
                        next = ListNode(2).apply {
                            next = ListNode(2).apply {
                                next = ListNode(2).apply {
                                    next = ListNode(2).apply {
                                        next = root
                                    }
                                }
                            }
                        }
                    }
                }
            }
        )?.`val`
    )
}

fun detectCycle(head: ListNode?): ListNode? {
    if (head == null)
        return null

    if (head.next == null)
        return null

    var fast = head
    var slow = head
    var _head = head

    while (fast?.next != null && fast.next?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) {
            while (true) {
                if (_head == slow || _head == fast) {
                    return _head
                }

                slow = slow?.next
                _head = _head?.next
                fast = fast?.next?.next
            }
        }
    }

    return null
}
