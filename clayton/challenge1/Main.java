package com.harera.leetcode.clayton.challenge1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class TreeNode implements Comparable<TreeNode> {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(TreeNode treeNode) {
        return Integer.compare(value, treeNode.value);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String commaSeparatedInput = input.next();
        TreeNode root = arrayToTree(commaSeparatedInput.split(","));
        TreeNode greatestNode = greatestNode(root);
        System.out.println(greatestNode.value);
    }

    public static TreeNode arrayToTree(String[] array) {
        return buildTreeToTree(array, 0);
    }

    private static TreeNode buildTreeToTree(String[] array, int idx) {
        if (idx >= array.length)
            return null;

        TreeNode head = new TreeNode(Integer.parseInt(array[idx]));
        head.left = buildTreeToTree(array, 2 * idx + 1);
        head.right = buildTreeToTree(array, 2 * idx + 2);
        return head;
    }

    public static TreeNode greatestNode(TreeNode root) {
        if (root == null)
            return null;

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        TreeNode left = greatestNode(root.left);
        if (left != null) {
            nodes.add(left);
        }

        TreeNode right = greatestNode(root.right);
        if (right != null) {
            nodes.add(right);
        }

        nodes.sort(Collections.reverseOrder());

        return nodes.get(0);
    }
}