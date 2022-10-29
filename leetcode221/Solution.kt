package LeetCode221

fun main() {
    println(
        maximalSquare(
            arrayOf(
                arrayOf('1', '0', '1', '0', '0').toCharArray(),
                arrayOf('1', '0', '1', '1', '1').toCharArray(),
                arrayOf('1', '1', '1', '1', '1').toCharArray(),
                arrayOf('1', '0', '0', '1', '0').toCharArray(),
            )
        )
    )
}
//[["1","0","1","0"],
// ["1","0","1","1"]
// ,["1","0","1","1"],
// ["1","1","1","1"]]


fun maximalSquare(matrix: Array<CharArray>): Int {
    val dp = Array<IntArray>(matrix.size + 1, { IntArray(matrix[0].size + 1) })

    for (i in dp.indices) {
        dp[i][0] = 0
    }

    for (i in dp[0].indices) {
        dp[0][i] = 0
    }

    var ans = 0
    for (i in 1..dp.lastIndex) {
        for (k in 1..dp[0].lastIndex) {
            dp[i][k] = matrix[i - 1][k - 1].minus('0')

            if (dp[i][k] == 0) {
                continue
            } else {
                dp[i][k] = arrayOf(
                    dp[i][k - 1], dp[i - 1][k - 1], dp[i - 1][k]
                ).sorted()[0] + 1
            }

            ans = if (ans < dp[i][k])
                dp[i][k]
            else
                ans
        }
    }

    return ans * ans
}