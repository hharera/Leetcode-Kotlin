package LeetCode708

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2, head)
    insert(
        head, 4
    ).let {
        var cur = it
        while (true) {
            println(cur.value)
            cur = cur.next!!
            if (cur == head)
                break
        }
    }
}

fun insert(node: ListNode?, x: Int): ListNode {
    if (node == null)
        return ListNode(value = x).apply {
            next = this
        }

    if (node.next == node) {
        node.next = ListNode(x, node)
        return node
    }

    var minNode = node
    var maxNode = node
    while (true) {
        if (maxNode!!.next == node) {
            break
        }
        maxNode = maxNode.next!!
    }

    if(x <= minNode.value!!) {
        val newNode = ListNode(x)
        maxNode!!.next = newNode
        newNode.next = minNode
        return node
    }

    if(x >= maxNode!!.value!!) {
        val newNode = ListNode(maxNode.value)
        maxNode.value = x
        maxNode.next = newNode
        newNode.next = node
        return node
    }

    while (true) {
        var curNode = node
        if (x >= curNode.value!! && x <= curNode.next!!.value!!) {
            val temp = curNode.next!!
            curNode.next = ListNode(x, temp)
            break
        }
        curNode = curNode.next
    }
    return node
}

class ListNode(
    var value: Int? = null,
    var next: ListNode? = null,
)
