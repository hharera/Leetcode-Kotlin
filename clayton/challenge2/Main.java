package com.harera.leetcode.clayton.challenge2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String input1 = input.next();
        String solution = sortVowels(input1);
        System.out.println(solution);
    }

    public static String sortVowels(String input) {
        PriorityQueue<Character> vowels = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isVowel(c)) {
                vowels.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isVowel(c)) {
                sb.append(vowels.poll());
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}