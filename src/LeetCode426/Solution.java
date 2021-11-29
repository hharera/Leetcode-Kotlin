package LeetCode426;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

class Solution {
    private Node head;
    public Node treeToDoublyList(Node root) {
        if(null == root) return null;
        Node last = dfs(root, null);

        last.right = head;
        head.left = last;
        return head;
    }
    private Node dfs(Node node, Node prev) {
        if(null == node) return null;

        Node leftRet = dfs(node.left, prev);
        if(null != leftRet) {
            prev = leftRet;
        }

        Node cur = new Node(node.val, null, null);
        if(null != prev) {
            cur.left = prev;
            prev.right = cur;
        }

        if(null == head) {
            head = cur;
        }

        Node rightRet = dfs(node.right, cur);
        return (null != rightRet) ? rightRet : cur;
    }
}