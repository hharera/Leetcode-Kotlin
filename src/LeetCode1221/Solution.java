package LeetCode1221;

class Solution {

    public int balancedStringSplit(String s) {
        int ans = 1;
        char p = s.charAt(0), c = 'C', next;
        for (int i = 1; i < s.length(); i++) {
            next = s.charAt(i);
            if (next != p && next != c) {
                c = next;
            } else if (next == p && c != 'C') {
                p = next;
                c = 'C';
                ans++;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().balancedStringSplit("RLRRRLLRLL"));
    }
    
}
