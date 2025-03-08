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
        int subStringLength = 0, subStringIndex = 0;
        StringBuilder stringLength = new StringBuilder();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (subStringLength <= 0){
                if (str.charAt(i) == '/') {
                    subStringLength = Integer.parseInt(stringLength.toString());
                    stringLength = new StringBuilder();
                    subStringIndex = i + 1;
                    if (subStringLength == 0) {
                        result.add("");
                    }
                } else {
                    stringLength.append(str.charAt(i));
                }
            } else {
                subStringLength--;
                if (subStringLength == 0) {
                    result.add(str.substring(subStringIndex, i + 1));
                }
            }
        }
        return result;
    }
}
