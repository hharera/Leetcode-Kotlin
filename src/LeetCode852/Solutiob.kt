package LeetCode852

fun main() {
    println(peakIndexInMountainArray(arr = arrayOf(18, 29, 38, 59, 98, 100, 99, 98, 90).toIntArray()))
}

fun peakIndexInMountainArray(arr: IntArray): Int {

    var start = 0
    var end = arr.lastIndex
    var mid = (start + end) / 2
    while (start < end) {
        mid = (start + end) / 2

        if (arr[mid] > arr[mid - 1] && arr[mid + 1] > arr[mid]) {
            start = mid
        } else if (arr[mid] < arr[mid - 1] && arr[mid + 1] < arr[mid]) {
            end = mid
        } else {
            break
        }
    }

    return mid
}