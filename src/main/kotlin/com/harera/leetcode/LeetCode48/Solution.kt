package LeetCode48


fun main() {
    rotate(
        arrayOf(
            arrayOf(
                1, 2, 3
            ).toIntArray(),
            arrayOf(
                4, 5, 6
            ).toIntArray(),
            arrayOf(
                7, 8, 9
            ).toIntArray(),
        )
    )
}

fun rotate(matrix: Array<IntArray>): Unit {

    for (row in matrix.indices)
        for (col in matrix[row].indices) {
            val temp = matrix[row][col]
            val newRow = col
            val newCol = matrix[row].size - row - 1

            matrix[row][col] = matrix[newRow][newCol]
            matrix[newRow][newCol] = temp
        }

}