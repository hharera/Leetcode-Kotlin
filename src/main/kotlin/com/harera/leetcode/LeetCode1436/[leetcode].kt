package LeetCode1436

import java.util.*

internal class Solution {
    lateinit var graph: Array<MutableList<Int?>>
    fun destCity(paths: List<List<String?>>): String? {
        graph = Array(201) { arrayListOf() }
        for (i in 0..200) {
            graph[i] = arrayListOf()
        }
        val map: MutableMap<String?, Int?> = HashMap()
        val m: MutableMap<Int?, String?> = HashMap()
        var c = 1
        for (path in paths) {
            for (string in path) {
                if (!map.containsKey(string)) {
                    map[string] = c
                    m[c] = string
                    c++
                }
            }
        }
        for (path in paths) {
            graph[map[path[0]]!!].add(map[path[1]])
        }
        var ans: String? = null
        val s: Stack<Int> = Stack()
        s.add(1)
        while (!s.isEmpty()) {
            val cur = s.pop()
            if (!graph[cur].isEmpty()) {
                for (u in graph[cur]) {
                    s.add(u)
                }
            } else {
                ans = m[cur]
            }
        }
        return ans
    }
}