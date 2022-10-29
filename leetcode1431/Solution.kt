package LeetCode1431

class LeetCode1431 {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        var max = -1
        for (i in candies.indices) {
            if (candies[i] > max) {
                max = candies[i]
            }
        }
        val ans: MutableList<Boolean> = ArrayList()
        for (i in candies.indices) {
            if (candies[i] + extraCandies >= max) {
                ans.add(true)
            } else {
                ans.add(false)
            }
        }
        return ans
    }
}