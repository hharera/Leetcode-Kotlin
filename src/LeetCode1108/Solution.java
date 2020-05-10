package LeetCode1108;

import java.util.StringTokenizer;

class Solution {

    public String defangIPaddr(String address) {

        StringTokenizer stk = new StringTokenizer(address, ".");
        StringBuilder sb = new StringBuilder();

        while (stk.hasMoreElements()) {
            sb.append(stk.nextToken() + "[.]");
        }
        address = sb.substring(0, sb.length()-3);

        return address;
    }
    
    
    public static void main(String[] args) {
        System.out.println(new Solution().defangIPaddr("1.1.1.1"));
    }
    
    
}
