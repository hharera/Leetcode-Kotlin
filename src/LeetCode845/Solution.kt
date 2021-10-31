package LeetCode845

import kotlin.math.max

fun main() {
    println(
        longestMountain(
            arrayOf(
                0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0
            ).toIntArray()
        )
    )
}

fun longestMountain(arr: IntArray): Int {
    var ans = 0
    var size = 1
    var curve = 'A'
    var curveChanged = false
    var lastElem = arr[0]

    for (i in 1..arr.lastIndex) {

        if (lastElem > arr[i]) {
            if (curve == 'A') {
                curve = 'D'
                curveChanged = true
            }

            lastElem = arr[i]
            size++
        }

        if (lastElem < arr[i]) {
            if (curve == 'D') {
                if (size >= 3 && size > ans)
                    ans = size

                lastElem = arr[i]
                size = 2
                curve = 'A'
                curveChanged = true
                continue
            }

            lastElem = arr[i]
            size++
        }
    }
    return if (size >= 3 && size > ans && curveChanged)
        size
    else
        ans
}

