//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    val s = "racecar"
    val t = "carrace"
    val solution = Solution()
    println(solution.isAnagram(s, t))

    val s2 = "jar" 
    val t2= "jam"
    println(solution.isAnagram(s2, t2))
}