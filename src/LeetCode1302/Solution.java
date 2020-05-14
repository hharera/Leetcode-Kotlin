package LeetCode1302;

class Solution {

    int max, level;

    public int deepestLeavesSum(TreeNode root) {

        max = 0;

        solve(root, 0, 0);

        return max;
    }

    public void solve(TreeNode t, int sum, int level) {
        if (t == null) {
            return;
        }

        solve(t.left, sum + t.val, level + 1);
        solve(t.right, sum + t.val, level + 1);

        if (level >= this.level) {
            max = Integer.max(max, sum);
        }
    }

    public static void main(String[] args) {
        int arr[] = {17, 18, 5, 4, 6, 1};

        int ans = new Solution().deepestLeavesSum(root);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
