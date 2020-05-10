package LeetCode1290;

class Solution {

    public int getDecimalValue(ListNode head) {
        String s = "";
        while (head != null) {
            s += head.val;
            head = head.next;
        }
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.pow(2, len - i - 1) * (Integer.parseInt(s.charAt(i) + ""));
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode h = new ListNode(1);
        h.next = new ListNode(0);
        h.next.next = new ListNode(1);
        System.out.println(new Solution().getDecimalValue(h));
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
