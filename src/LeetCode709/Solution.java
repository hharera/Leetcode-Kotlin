package LeetCode709;

class Solution {
    
    public String toLowerCase(String str) {
        
        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            ans.append(Character.toLowerCase(str.charAt(i)));
        }
        return ans.toString();
    }
}
