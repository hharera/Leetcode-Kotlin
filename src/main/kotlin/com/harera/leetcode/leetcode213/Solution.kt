package leetcode213

//class Solution {
//    fun rob(nums: IntArray): Int {
//        val houses = nums.mapIndexed { index, amount ->
//            House(amount, index)
//        }.sortedByDescending {
//            it.amount
//        }
//
//        val robbedHouses = HashSet<Int>()
//        var result = 0
//
//        houses.forEach {
//            if (
//                robbedHouses.contains((it.index + 1 + houses.size ) % houses.size) ||
//                robbedHouses.contains((it.index - 1 + houses.size ) % houses.size)
//            ) {
//
//            } else {
//                result += it.amount
//                robbedHouses.add(it.index)
//            }
//        }
//
//        return result
//    }
//
//    class House(
//        val amount : Int,
//        val index : Int
//    )
//}

class Solution {

    fun rob(nums: IntArray): Int {
        return arrayOf(
            nums[0],
            solve(nums.dropLast(1)),
            solve(nums.drop(1))
        ).sortedArrayDescending().first()
    }

    fun solve(nums: List<Int>): Int {
        var rob1 = 0
        var rob2 = 0

        for (index: Int in 0..nums.lastIndex) {
            val temp = if (rob1 + nums[index] > rob2) {
                rob1 + nums[index]
            } else {
                rob2
            }
            rob1 = rob2
            rob2 = temp
        }

        return rob2
    }
}
