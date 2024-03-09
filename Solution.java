package com.harera.leetcode;

import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello, World!");
        // read string

    }
    public int mainAnInt(String s) {
        int[] charIndex = new int[128];
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            if (charIndex[s.charAt(right)] > 0) {
                left = Math.max(left, charIndex[s.charAt(right)]);
            }
            charIndex[s.charAt(right)] = right + 1;
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
