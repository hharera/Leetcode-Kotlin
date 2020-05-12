package LeetCode1299;

class Solution {

    public int[] replaceElements(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int bigest = arr[i+1];
            for (int j = i + 2; j < arr.length; j++) {
                if (arr[j] > bigest) {
                    bigest = arr[j];
                }
            }
            arr[i] = bigest;
        }
        arr[arr.length - 1] = -1;
    
        return arr;
    }

    public static void main(String[] args) {
        int arr [] = {17,18,5,4,6,1};
        
        new Solution().replaceElements(arr);
        
        for (int i : arr) {
            System.out.println(i);
        }
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
