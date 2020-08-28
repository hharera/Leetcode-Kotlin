package Leetcode905;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public int[] sortArrayByParity(int[] A) {
        List<Integer> odd = new ArrayList();
        List<Integer> even = new ArrayList();

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                even.add(A[i]);
            } else {
                odd.add(A[i]);
            }
        }

        int[] ans = new int[A.length];

        int count = 0;
        for (int i = 0; i < even.size(); i++, count++) {
            ans[count] = even.get(i);
        }
        for (int i = 0; i < odd.size(); i++, count++) {
            ans[count] = odd.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int ans[] = new Solution().sortArrayByParity(arr);
        
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
