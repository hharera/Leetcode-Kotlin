package LeetCode1323;

class Solution {

    public int maximum69Number(int num) {

        StringBuilder n = new StringBuilder().append(num);
        StringBuilder ans = null;
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '6') {
                ans = new StringBuilder();
                ans = ans.append(n.subSequence(0, i)).append("9").append(n.substring(i + 1, n.length()));
                break;
            }
        }
        
        if(ans == null){
            ans = new StringBuilder().append(n);
        }
        
        return Integer.parseInt(ans.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximum69Number(9999));
    }
}
