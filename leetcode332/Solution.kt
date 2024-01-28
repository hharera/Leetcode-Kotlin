package com.harera.leetcode.leetcode332

class Solution {

    private val graph = HashMap<String, HashSet<String>>()
    fun findItinerary(tickets: List<List<String>>): List<String> {
        tickets.forEach {
            graph[it[0]] = graph.getOrDefault(it[0], HashSet()).apply {
                add(it[1])
            }
        }
        return solve("JFK", tickets.size).also {
            println(it)
        }
    }

    private fun solve(source: String, tickets: Int): List<String> {
        var list = mutableListOf<List<String>>()

        val temp = graph[source]?.toList()
        temp?.forEach { dest ->
            graph[source]?.remove(dest)
            list.add(listOf(source) + solve(dest, tickets - 1))
            graph[source]?.add(dest)
        }
        println(list + " " + tickets)
        list
            .filter {
                it.size == tickets
            }
            .let {
                if (it.isEmpty())
                    return listOf(source)
                it.sortedBy {
                    it.joinToString(" ")
                }.first()
            }.let {
                return listOf(source) + it
            }
    }
}

//JFK ANU EZE AXA TIA ANU JFK TIA ANU TIA JFK"
fun main() {
    val solution = Solution()
    //[["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
    println(
        solution.findItinerary(
            listOf(
                listOf("EZE", "AXA"),
                listOf("TIA", "ANU"),
                listOf("ANU", "JFK"),
                listOf("JFK", "ANU"),
                listOf("ANU", "EZE"),
                listOf("TIA", "ANU"),
                listOf("AXA", "TIA"),
                listOf("TIA", "JFK"),
                listOf("ANU", "TIA"),
                listOf("JFK", "TIA")
            )
        )
    )
}