package LeetCode240

fun main() {
    searchMatrix(
        arrayOf(
            arrayOf(
                -5
            ).toIntArray()
        ),
        -5
    )
}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    for (i in matrix.indices) {
        val res = matrix[i].binarySearch(target)
        if (res >= 0) {
            return true
        }
    }
    return false
}