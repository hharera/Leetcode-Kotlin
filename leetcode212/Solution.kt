package com.harera.leetcode.leetcode212


class Solution {

    private lateinit var board: Array<CharArray>
    private lateinit var resultWords: MutableSet<String>

    class TrieNode {
        val children = mutableMapOf<Char, TrieNode>()
        var isWord = false
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        this.board = board
        this.resultWords = mutableSetOf()

        val root = buildTrie(words)

        val visited = Array(board.size) { Array(board[0].size) { false } }
        for (row in board.indices) {
            for (col in board[0].indices) {
                search(row, col, "", visited, root)
            }
        }

        return resultWords.toList()
    }

    private fun search(
        row: Int,
        col: Int,
        prevString: String,
        visited: Array<Array<Boolean>>,
        node: TrieNode
    ) {
        if (row < 0 || row >= board.size || col < 0 || col >= board[0].size)
            return

        val trieNode = node.children[board[row][col]] ?: return
        if (visited[row][col])
            return

        val curStr = prevString.plus(board[row][col])
        if (trieNode.isWord)
            resultWords.add(curStr)

        visited[row][col] = true
        search(row + 1, col, curStr, visited, trieNode)
        search(row - 1, col, curStr, visited, trieNode)
        search(row, col + 1, curStr, visited, trieNode)
        search(row, col - 1, curStr, visited, trieNode)
        visited[row][col] = false
    }

    private fun buildTrie(words: Array<String>): TrieNode {
        val root = TrieNode()
        for (word in words) {
            var node = root
            for (char in word) {
                node.children.getOrPut(char) { TrieNode() }
                node = node.children[char]!!
            }
            node.isWord = true
        }
        return root
    }
}

fun main() {
    var solution = Solution()
    //[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]

    println(
        solution.findWords(
            arrayOf(
                charArrayOf('o', 'a', 'a', 'n'),
                charArrayOf('e', 't', 'a', 'e'),
                charArrayOf('i', 'h', 'k', 'r'),
                charArrayOf('i', 'f', 'l', 'v')
            ),
            arrayOf("oath", "pea", "eat", "rain")
        )
    )

    println(
        solution.findWords(
            arrayOf(
                charArrayOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
                charArrayOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
//                charArrayOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
//                charArrayOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
//                charArrayOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
//                charArrayOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
//                charArrayOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
//                charArrayOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
                charArrayOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
                charArrayOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
                charArrayOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'),
                charArrayOf('a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a')
            ),
            arrayOf(
                "a",
                "aa",
                "aaa",
                "aaaa",
                "aaaaa",
                "aaaaaa",
                "aaaaaaa",
                "aaaaaaaa",
                "aaaaaaaaa",
                "aaaaaaaaaa"
            )
        )
    )
}