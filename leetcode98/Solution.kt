//package com.harera.leetcode.leetcode98
//
//
//import java.util.*
//
//
//class TreeNode(var `val`: Int) {
//    var left: TreeNode? = null
//    var right: TreeNode? = null
//}
//
//class Solution {
//
//    fun isValidBST(root: TreeNode?): Boolean {
//        if (root == null)
//            return true
//
//        val minHeap = PriorityQueue<Int>(Comparator { t, t2 ->
//            return@Comparator t - t2
//        })
//        val maxHeap = PriorityQueue<Int>(Comparator { t, t2 ->
//            return@Comparator t2 - t
//        })
//
//        minHeap.add(root.`val`)
//        maxHeap.add(root.`val`)
//        return check(root, minHeap, maxHeap)
//    }
//
//    private fun check(root: TreeNode?, queue: PriorityQueue<Int>): PriorityQueue<Int> {
//        if (root == null) {
//            return queue
//        }
//
//        if (root.left != null) {
//            if (root.left!!.`val` >= root.`val`)
//                return false
//        }
//        if (root.right != null) {
//            if (root.right!!.`val` <= root.`val`)
//                return false
//        }
//
//        queue.add(root.`val`)
//        check(root.left, queue)
//        check(root.right, queue)
//    }
//
//    private fun createMaxHeap(): PriorityQueue<Int> {
//        return PriorityQueue<Int>(Comparator { t, t2 ->
//            return@Comparator t2 - t
//        })
//    }
//
//    private fun createMinHeap(): PriorityQueue<Int> {
//        return PriorityQueue<Int>(Comparator { t, t2 ->
//            return@Comparator t - t2
//        })
//    }
//}
//
//
//fun main() {
//    val solution = Solution()
//    //[5,4,6,null,null,3,7]
//    val root = TreeNode(5)
//    root.left = TreeNode(4)
//    root.right = TreeNode(6)
//    root.right?.left = TreeNode(3)
//    root.right?.right = TreeNode(7)
//    println(solution.isValidBST(root))
//}