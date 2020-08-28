package LeetCode1470;

class Solution {

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        for (int i = 0, j = 0; i < n; i++, j += 2) {
            ans[j] = nums[i];
        }
        
        for (int i = n, j = 1; i < nums.length; i++, j+=2) {
            ans[j] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int test[] = {1, 2, 8, 9, 7, 9};
        int[] ans = new Solution().shuffle(test, 3);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
