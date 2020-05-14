package LeetCode1313;

import java.util.*;


class Solution {

     public int[] decompressRLElist(int[] nums) {
         
         List<Integer> list = new ArrayList();
         
         for (int i = 0; i < nums.length; i+=2) {
             for (int j = 0; j < nums[i]; j++) {
                 list.add(nums[i+1]);
             }
         }
         
         int [] ans = new int[list.size()];
         
         for (int i = 0; i < ans.length; i++) {
             ans[i] = list.get(i);
         }
         
         return ans;
    }

    public static void main(String[] args) {
        int arr [] = {1,1,2,3};
        
        int ans [] = new Solution().decompressRLElist(arr);
        
        for (int i : ans) {
            System.out.println(i);
        }
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
