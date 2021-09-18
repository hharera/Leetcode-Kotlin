package LeetCode3;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static int lengthOfLongestSubstring(String s) {
        int longest = 0, count = 0, c = 0;
        Map<Character, Integer> set = new HashMap();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (set.containsKey(cur)) {
                c = Integer.max(c, set.get(cur));
                longest = Integer.max(longest, count);
                count = i - c;
                set.put(cur, i);
            } else {
                set.put(cur, i);
                count++;
            }
        }

        return Integer.max(longest, count);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("alllla"));
    }
}
