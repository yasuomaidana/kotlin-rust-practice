package org.example

fun main() {
    val s = "aaaaaaaaaaaabbbbbcdd" 
    val t = "abcdd"
    
    val letterCount = t.groupingBy { it }.eachCount()
    
    var currentAnswer = LettersManager(letterCount)
    var weakAnswer = LettersManager(letterCount)
    for (letter in s){
        if (!currentAnswer.containsAllNeededLetters()){
            currentAnswer.addLetter(letter)
            weakAnswer.addLetter(letter)
        }else{
            if (weakAnswer.containsAllNeededLetters()){
                while(weakAnswer.containsAllNeededLetters()){
                    weakAnswer.removeLetter()
                }
            }
            weakAnswer.addLetter(letter)
            weakAnswer.clearHead()
        }
        if (currentAnswer.smallest()){
            break
        }
        if (weakAnswer.size() < currentAnswer.size() && weakAnswer.containsAllNeededLetters()){
            val temp = weakAnswer
            weakAnswer = currentAnswer
            currentAnswer = temp
        }
    }
    currentAnswer.clearHead()
    println(currentAnswer.subString())
}