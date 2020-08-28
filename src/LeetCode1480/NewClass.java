package LeetCode1480;

class Solution {
    public int[] runningSum(int[] nums) {
        int ans[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int curr = 0;
            for (int j = 0; j <= i; j++) {
                curr+= nums[j];
            }
            ans[i] = curr;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int [] test = {1,2,5,8,9};
        int [] ans = new Solution().runningSum(test);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}