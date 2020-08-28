package LeetCode.RemoveDuplicatesfromSortedArray;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {

    public int removeDuplicates(int[] nums) {

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }

        int ans = map.keySet().size();
        nums = new int[ans];

        int i = 0;
        Set<Integer> set = map.keySet();
        for (Integer inte : set) {
            nums[i] = inte;
            i++;
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates(new int[]{1,1,2}));
    }
    
}
