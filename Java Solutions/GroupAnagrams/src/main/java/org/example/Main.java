package org.example;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<String> words =List.of("act","pots","tops","cat","stop","hat");
        Solution solution = new Solution();
        List<List<String>> result = solution.groupAnagrams(words.toArray(new String[0]));
        System.out.println(result);
        System.out.println("Expected:");
        System.out.println("[[\"act\",\"cat\"],[\"pots\",\"tops\",\"stop\"],[\"hat\"]]");
    }
}