fun groupAnagrams(wordsList: Array<String>): List<List<String>> {

    fun generateCharCount(): IntArray {
        return IntArray(26)
    }

    val map = mutableMapOf<String, MutableList<String>>()
    
    for (str in wordsList) {
        val charCount = generateCharCount()
        for (c in str) {
            charCount[c - 'a']++
        }
        val key = charCount.joinToString(separator = ",")
        map.getOrPut(key) { mutableListOf() }.add(str)
    }
    
    return map.values.toList()
}

fun main() {
    val wordsList = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    val result = groupAnagrams(wordsList)
    println(result)

    val wordsList2 = arrayOf("a")
    val result2 = groupAnagrams(wordsList2)
    println(result2)

    val wordsList3 = arrayOf("")
    val result3 = groupAnagrams(wordsList3)
    println(result3)
}