//fun nextGreaterElements(nums: IntArray): IntArray {
//    val arrayList  = ArrayList<Num>()
//    nums.forEachIndexed { index, `val` ->
//        arrayList.add(Num(`val`, index))
//    }
//    arrayList.sort()
//
//    val ans = ArrayList<Int>()
//    nums.forEachIndexed { index, num ->
//        var start = 0
//        var end = arrayList.lastIndex
//
//        while (start < end) {
//            val mid = (start + end) / 2
//
//            if (arrayList[mid].`val` <= num) {
//                start = mid + 1
//            } else {
//                if(arrayList[mid].idx < index)
//
//                    else
//            }
//        }
//    }
//}
//
//data class Num(var `val`: Int, var idx: Int) : Comparable<Num> {
//    override fun compareTo(other: Num): Int =
////        if (other.`val` == `val`)
////            other.idx - idx
////        else
//            `val` - other.`val`
//}
//
//fun main() {
//
//}