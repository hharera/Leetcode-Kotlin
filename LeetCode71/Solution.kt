package LeetCode71

import java.util.*

class Solution {
    fun simplifyPath(path: String): String {
        var pathClone = path.toString()

        pathClone = pathClone.replace(
            "//",
            "/"
        )
        if(pathClone.last() == '/'){
            pathClone.dropLast(1)
        }

        val s = Stack<String>()
        val stk = StringTokenizer(pathClone, "/")
        while (stk.hasMoreTokens()) {
            val token = stk.nextToken()
            if (token == "..") {
                if (s.isNotEmpty())
                    s.pop()
            } else if (token == ".") {
                continue
            } else {
                s.push(token)
            }
        }

        var ans = StringBuilder()

        if (s.isEmpty())
            ans.append("/")

        s.reverse()
        while (s.isNotEmpty())
            ans.append("/${s.pop()}")

        return ans.toString()
    }
}

fun main() {
    println(Solution().simplifyPath("/home//foo/"))
}