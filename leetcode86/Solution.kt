package LeetCode86


class LeetCode86 {
    fun main() {

        var _head = ListNode(`val` = 1).apply {
            next = ListNode(`val` = 4).apply {
                next = ListNode(`val` = 3).apply {
                    next = ListNode(`val` = 2).apply {
                        next = ListNode(`val` = 5).apply {
                            next = ListNode(`val` = 2).apply {
                            }
                        }
                    }
                }
            }
        }

        var result = partition(
            _head,
            3
        )

        while (result != null) {
            println(result.`val`)
            result = result.next
        }
    }

    fun partition(head: ListNode?, x: Int): ListNode? {
        var _head = head
        while (_head != null) {

            if (_head.`val` >= x) {
                val elem = searchForElemLessThanX(_head, x)

                if (elem != null) {
                    val oldVal = _head.`val`
                    _head.apply {
                        `val` = elem.`val`
                        next = ListNode(oldVal).apply {
                            next = _head!!.next
                        }
                    }
                }
            }
            _head = _head.next
        }
        return head
    }

    fun searchForElemLessThanX(_head: ListNode, x: Int): ListNode? {
        var head = _head
        while (head.next != null) {
            if (head.next!!.`val` < x) {
                val req = head.next
                head.next = head.next!!.next
                return req
            }

            head = head.next!!
        }
        return null
    }


    inner class ListNode {
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
