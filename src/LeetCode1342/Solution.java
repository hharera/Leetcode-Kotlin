
package LeetCode1342;

class Solution {

    public int numberOfSteps(int num) {

        int ans = 0;

        while (num != 0) {
            if (num % 2 == 0) {
                num/=2;
            } else {
                num--;
            }
            ans++;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSteps(123));
    }
    
}

