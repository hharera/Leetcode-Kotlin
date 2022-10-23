package Leetcode83

import kotlin.math.max
import kotlin.math.min

fun main() {


}

fun largestRectangleArea(heights: IntArray): Int {
    val possibleHeight = IntArray(heights.size)
    var max = -1

    for (idx in heights.indices) {
        if(idx > 0) {
            possibleHeight[idx] = max(possibleHeight[idx], min(heights[idx-1], heights[idx]))
        }
        if(idx < heights.lastIndex) {
            possibleHeight[idx] = max(possibleHeight[idx], min(heights[idx+1], heights[idx]))
        }
        max = max(possibleHeight[idx], max)
    }
    var counter = 1
    val curHeight = possibleHeight[0]
    val ans = possibleHeight[0]
    for (idx in 1..possibleHeight.lastIndex) {
        if(curHeight == possibleHeight[idx]) {
            counter++
        } else {
            
        }
    }
    return ans
}