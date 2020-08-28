package LeetCode617;

class Solution {

    TreeNode[] T1, T2, newTtree;

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        T1 = T2 = newTtree = new TreeNode[10000];

        fillTree(T1, t1, 0);
        fillTree(T2, t2, 0);

        fillAnswer();
        
        TreeNode t = null;
        return fillNewTree(t, 0);
    }

    private void fillTree(TreeNode[] T1, TreeNode t1, int i) {
        if (t1 == null) {
            T1[i] = null;
            return;
        }

        T1[i] = t1;

        fillTree(T1, t1.left, i * 2 + 1);
        fillTree(T1, t1.right, i * 2 + 2);
    }

    private TreeNode fillNewTree(TreeNode t, int i) {
        if (newTtree[i] == null) {
            return null;
        }

        t = newTtree[i];

        fillNewTree(t.left, i * 2 + 1);
        fillNewTree(t.right, i * 2 + 2);
        
        return t;
    }

    private void fillAnswer() {
        for (int i = 0; i < T1.length; i++) {
            if (T1[i] != null && T2[i] != null) {
                newTtree[i] = new TreeNode(T2[i].val + T1[i].val);
            } else if (T2[i] == null) {
                newTtree[i] = T1[i];
            } else if (T1[i] == null) {
                newTtree[i] = T2[i];
            } else {
                newTtree[i] = null;
            }
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
