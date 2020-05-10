package LeetCode1365;

class Solution {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[j] < nums[i]) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {8, 1, 2, 2, 3};
        int[] ans = new Solution().smallerNumbersThanCurrent(nums);
        for (int an : ans) {
            System.out.println(an);
        }
    }

}
