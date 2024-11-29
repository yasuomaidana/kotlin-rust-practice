class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val sWordCount = HashMap<Char, Int>()
        val tWordClass = HashMap<Char, Int>()
        for ((si,ti) in s.zip(t)) {
            sWordCount[si] = sWordCount.getOrDefault(si, 0) + 1
            tWordClass[ti] = tWordClass.getOrDefault(ti, 0) + 1
        }
        return sWordCount == tWordClass
    }
}