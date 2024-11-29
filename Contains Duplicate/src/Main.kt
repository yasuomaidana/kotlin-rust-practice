//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    val arr1 = intArrayOf(1, 2, 3, 3)
    val sol1 = Solution()
    println("Has duplicate: ${sol1.hasDuplicate(arr1)}")
    
    val arr2 = intArrayOf(1, 2, 3, 4)
    val sol2 = Solution()
    println("Has duplicate: ${sol2.hasDuplicate(arr2)}")
}