package org.example

class LettersManager(letterCountReference: Map<Char, Int>) {

    private var letters = mutableListOf<Char>()
    private var letterCount = mutableMapOf<Char, Int>()
    private val letterCountReference: Map<Char, Int> = letterCountReference
    private var neededLetters = 0

    fun addLetter(letter: Char) {

        if (letter in letterCountReference) {
            letters.add(letter)
            letterCount[letter] = letterCount.getOrDefault(letter, 0) + 1
            val count = letterCount.getOrDefault(letter, 0)
            if (count == letterCountReference[letter]) {
                neededLetters += 1
            }
        } else if (neededLetters != 0) {
            letters.add(letter)
        }
    }

    fun removeLetter() {
        val letter = letters.removeAt(0)
        if (letter in letterCountReference) {
            val count = letterCount.getOrDefault(letter, 0) - 1
            if (count < letterCountReference[letter]!!) {
                neededLetters -= 1
            }
            letterCount[letter] = count
        }
    }

    fun containsAllNeededLetters(): Boolean {
        return neededLetters == letterCountReference.size
    }

    fun size() = letters.size

    fun smallest() = neededLetters == letterCountReference.size && letters.size == neededLetters

    fun subString() = letters.joinToString("")

    fun clearHead() {
        while (containsAllNeededLetters()) {
            val letter = letters.first()
            if (letter in letterCountReference && letterCount[letter]!! > letterCountReference[letter]!!) {
                removeLetter()
            }else if (letter in letterCountReference && letterCount[letter]!! == letterCountReference[letter]!!){
                break
            }else{
                removeLetter()
            }
        }
        while (!containsAllNeededLetters()) {
            val letter = letters.first()
            if (letter in letterCountReference && letterCount[letter]!! < letterCountReference[letter]!!) {
                break
            } else if (letter in letterCountReference && !containsAllNeededLetters()) {
                break
            }
            removeLetter()
        }
    }
}