package LeetCode1281;

class Solution {

    public int subtractProductAndSum(int n) {
        String N = n + "";
        long product = 1;
        int sum = 0;
        for (int i = 0; i < N.length(); i++) {
            int cur = Integer.parseInt(N.charAt(i) + "");
            product *= cur;
            sum += cur;
        }

        return (int) (product - sum);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subtractProductAndSum(111));
    }
}
