class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val set = HashSet<Int>()
        nums.iterator().forEach { num ->
            if (!set.add(num)){
                return true
            }
        }
        return false
    }
}