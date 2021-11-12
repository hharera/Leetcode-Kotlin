package LeetCode31

fun main() {


}

fun nextPermutation(nums: IntArray): Unit {
    var second = nums.lastIndex
    var first = nums.lastIndex - 1

    while (first > -1) {
        if (nums[second] > nums[first]) {
            break
        }

        first--
        second--
    }

    if (first < 0) {
        nums.reverse()
    } else {
        second = nums.lastIndex
        while (first < second) {
            if (nums[second] > nums[first]) {
                val temp = nums[second]
                nums[second] = nums[first]
                nums[first] = temp

                nums.sort(first + 1, nums.size)
                break
            }
            second--
        }
    }
}