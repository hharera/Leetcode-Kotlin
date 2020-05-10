package LeetCode938;

class Solution {

    static Boolean vis[] = new Boolean[10005];

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (vis[root.val]) {
            return 0;
        }

        int ans = 0;

        if (vis[root.val] == null) {
            vis[root.val] = true;
            if (root.val <= R && root.val >= L) {
                ans += root.val;
            }
        }

        ans += rangeSumBST(root.left, L, R);
        ans += rangeSumBST(root.right, L, R);

        return ans;
    }

    public static void main(String[] args) {
        if (vis[500] == null) {
            System.out.println("right");

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
