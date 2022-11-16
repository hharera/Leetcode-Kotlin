
package com.harera.leetcode.leetcode271;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str).append(" ");
        }
        return encoded.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        String[] split = str.substring(0, str.length() - 1).split(" ");
        List<String> decoded = new ArrayList<>();
        for (String s : split) {
            decoded.add(s);
        }
        return decoded;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strs = List.of("Hello", "World");
    }
}