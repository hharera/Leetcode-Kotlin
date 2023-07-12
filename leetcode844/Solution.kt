import java.util.*

class Solution {
    fun backspaceCompare(s: String, t: String): Boolean {
        val tQueue = Stack<Char>()
        val sQueue = Stack<Char>()
        for (char in s) {
            if (char == '#') {
                if (sQueue.isNotEmpty())
                    sQueue.pop()
            } else {
                sQueue.add(char)
            }
        }
        for (char in t) {
            if (char == '#') {
                if (tQueue.isNotEmpty())
                    tQueue.pop()
            } else {
                tQueue.add(char)
            }
        }
        return tQueue.toString() == sQueue.toString()
    }
}

fun main() {
    val solution = Solution()
    println(solution.backspaceCompare("xywrrm#p", "xywrrmp"))
}