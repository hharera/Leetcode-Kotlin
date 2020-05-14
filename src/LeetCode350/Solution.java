package LeetCode350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for (int i = 0, j = 0; i < nums1.length; i++) {
            for (; j < nums2.length && nums2[j] <= nums1[i]; j++) {
                if (nums1[i] == nums2[j]) {
                    ans.add(nums1[i]);
                    j++;
                    break;
                }
            }
        }
        
        int a[] = new int[ans.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = ans.get(i);
        }

        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1};
        int[] b = {2};
        
        int ans[] = new Solution().intersect(a, b);
        
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
