package LeetCode961;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int repeatedNTimes(int[] A) {
        int ans = 1;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                ans = A[i];
                break;
            } else {
                map.put(A[i], ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{5,1,5,2,5,3,5,4};
        int ans = new Solution().repeatedNTimes(arr);
        System.out.println(ans);
    }
}
