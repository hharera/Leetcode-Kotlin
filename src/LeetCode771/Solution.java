/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode771;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author harera
 */
class Solution {

    public int numJewelsInStones(String J, String S) {
        Map<Character, Integer> chars = new HashMap();

        for (int i = 0; i < J.length(); i++) {
            chars.put(J.charAt(i), 1);
        }
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            if (chars.containsKey(S.charAt(i))) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numJewelsInStones("z", "ZZ"));
        
    }

}
