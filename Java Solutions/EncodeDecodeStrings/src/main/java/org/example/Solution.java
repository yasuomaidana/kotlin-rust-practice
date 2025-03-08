package org.example;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collector;
//import java.util.stream.Collectors;

public class Solution {

//    public static Collector<String, StringBuilder, String> encoderBuilder() {
//        return Collector.of(
//                StringBuilder::new,
//                (sb, str) -> sb.append(str.length()).append('/').append(str),
//                StringBuilder::append,
//                StringBuilder::toString
//        );
//    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append('/').append(str);
        }
//        return strs.stream().collect(encoderBuilder());
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> result = new ArrayList<>();
        int wordLength = -1;
        int slashIndex = 0;
        while (i < str.length()) {
            if (wordLength < 0 && str.charAt(i) == '/') {
                wordLength = Integer.parseInt(str.substring(slashIndex, i));
                slashIndex = i + 1;
                if (wordLength == 0) {
                    result.add("");
                    wordLength = -1;
                }
            } else if (wordLength >= 0) {
                i = slashIndex + wordLength;
                result.add(str.substring(slashIndex, i));
                slashIndex = i;
                wordLength = -1;
            }
            i++;
        }
        return result;
    }
}
