package LeetCode1379;

class Solution {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        TreeNode ans = null;
        
        if(original == null){
            return null;
        }
        
        if (target.val == original.val) {
            return cloned;
        }
        
        ans = ans == null ? getTargetCopy(original.left, cloned.left, target) : ans;
        ans = ans == null ? getTargetCopy(original.right, cloned.right, target) : ans;

        return ans;
    }

    public static void main(String[] args) {

    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
