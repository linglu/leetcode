package com.linky.easy;

/**
 * Trim a Binary Search Tree
 * https://leetcode.com/problems/trim-a-binary-search-tree/description/
 */
public class Topic669 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {

        if (root == null) {
            return null;
        }

        while (root.val < L || root.val > R) {
            root = sink(root);
            if (root == null)
                break;
        }

        if (root != null) {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        }

        return root;
    }

    private TreeNode sink(TreeNode node) {

        if (node.left != null) {
            int tmp = node.val;
            node.val = node.left.val;
            node.left.val = tmp;
            node.left = sink(node.left);
        } else if (node.right != null) {
            int tmp = node.val;
            node.val = node.right.val;
            node.right.val = tmp;
            node.right = sink(node.right);
        } else {
            return null;
        }

        return node;
    }
}
