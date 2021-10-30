package LeetCode42

fun main() {

}

fun trap(height: IntArray): Int {
    var leftIdx = 0
    var rightIdx = height.lastIndex

    var maxLeft = 0
    var maxRight = 0

    var ans = 0
    while (leftIdx <= rightIdx) {
        if (height[leftIdx] <= height[rightIdx]) {
            if (height[leftIdx] > maxLeft)
                maxLeft = height[leftIdx]
            else
                ans += maxLeft - height[leftIdx]
            leftIdx++
        } else {
            if (height[rightIdx] > maxRight)
                maxRight = height[rightIdx]
            else
                ans += maxRight - height[rightIdx]
            rightIdx--
        }
    }

    return ans
}