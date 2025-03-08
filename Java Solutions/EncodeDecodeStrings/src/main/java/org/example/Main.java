package org.example;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String encoded = solution.encode(List.of("neet","code","love","you"));
        System.out.println(encoded);
        List<String> decoded = solution.decode(encoded);
        System.out.println(decoded);
        
        encoded = solution.encode(List.of(""));
        System.out.println(encoded);
        decoded = solution.decode(encoded);
        System.out.println(decoded);
    }
}