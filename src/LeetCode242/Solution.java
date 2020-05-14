package LeetCode242;

class Solution {

    public boolean isAnagram(String s, String t) {

        int[] a = new int[26];
        int[] b = new int[26];

        Boolean isEqual;
        
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < t.length(); i++) {
            b[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("a", "ab"));
    }
}
