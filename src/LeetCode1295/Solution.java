package LeetCode1295;

class Solution {

    public int findNumbers(int[] nums) {

        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {12, 345, 2, 6, 7896};

        int ans = new Solution().findNumbers(arr);


        System.out.println(ans);
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
