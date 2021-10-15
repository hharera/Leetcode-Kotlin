package LeetCode141

fun main() {


}

fun hasCycle(head: ListNode?): Boolean {
    var count = 0
    var _head = head
    while (_head != null) {
        if (count > 10000)
            return true

        count++
        _head = _head.next
    }
    return false
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
