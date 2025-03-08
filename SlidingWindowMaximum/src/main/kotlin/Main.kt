package org.example

import java.util.ArrayDeque

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val output = mutableListOf<Int>()
    val q = ArrayDeque<Int>()
    var l = 0

    for (r in nums.indices) {
        while (q.isNotEmpty() && nums[q.last()] < nums[r]) {
            q.removeLast()
        }
        q.addLast(r)
        if (l > q.first()) {
            q.removeFirst()
        }
        if ((r + 1) >= k) {
            output.add(nums[q.first()])
            l += 1
        }
    }
    
    return output.toIntArray()
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    val k = 3
    val nums = intArrayOf(1, 3, 5, 7, 6, 4, 3, 9)
    val result = maxSlidingWindow(nums, k)
    println(result.contentToString())
}