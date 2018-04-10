package com.linky.easy;

import com.linky.stdlib.StdIn;
import com.linky.stdlib.StdOut;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Merge Two Binary Trees
 * https://leetcode.com/problems/merge-two-binary-trees/description
 */
public class Topic617 {

    /*
     * Definition for a binary tree node
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     *
     */
    public TreeNode mergeTree(TreeNode t1, TreeNode t2) {

        TreeNode root = null;
        if (t1 != null && t2 != null) {
            root = new TreeNode(t1.val + t2.val);
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }

        if (t1 != null && t2 == null) {
            root = t1;
        }

        if (t1 == null && t2 != null) {
            root = t2;
        }

        return root;
    }


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        // 广度优先遍历
        List<Integer> l1, l2;

        l1 = fromTreeNodeToList(t1);
        l2 = fromTreeNodeToList(t2);

        int size = Math.max(l1.size(), l2.size());

        Integer[] array1 = new Integer[size];
        Integer[] array2 = new Integer[size];

        l1.toArray(array1);
        l2.toArray(array2);

        for (int i = 0; i < size; i++) {

            if (array1[i] == null && array2[i] == null) {
                array1[i] = null;
            } else {

                if (array1[i] == null) {
                    array1[i] = 0;
                } else if (array2[i] == null) {
                    array2[i] = 0;
                }

                array1[i] += array2[i];
            }
        }

//        StdOut.println("\narray 1: ");
//        for (int i = 0; i < array1.length; i++) {
//            StdOut.print(array1[i] + " ");
//        }

        return createTreeNode(array1, 0);

    }

    public List<Integer> fromTreeNodeToList(TreeNode tn) {

        List<Integer> li = new ArrayList<>();

        if (tn == null) {
            return li;
        }

        LinkedList<TreeNode> ll = new LinkedList<>();
        ll.addFirst(tn);

        while (!ll.isEmpty()) {
            TreeNode node = ll.poll();

            if (node != null) {
                li.add(node.val);

                if (node.left != null) {
                    ll.add(node.left);
                } else if (node.right != null) {
                    ll.add(null);
                }

                if (node.right != null) {
                    ll.add(node.right);
                } else if (node.left != null) {
                    ll.add(null);
                }

            } else {
                li.add(null);
            }
        }

        return li;
    }

    private List<Integer> getBfsOrder1(TreeNode tn) {

        List<Integer> li = new ArrayList<>();

        if (tn == null) {
            return li;
        }

        ArrayDeque<TreeNode> ad = new ArrayDeque<>();
        ad.add(tn);

        while (!ad.isEmpty()) {
            TreeNode node = ad.poll();

            if (node.val != 0) {
                li.add(node.val);
            } else {
                li.add(null);
            }

            if (node.left != null) {
                ad.add(node.left);
            } else if (node.right != null) {
                ad.add(new TreeNode(0));
            }

            if (node.right != null) {
                ad.add(node.right);
            } else if (node.left != null) {
                ad.add(new TreeNode(0));
            }
        }

        return li;
    }

    /**
     * 3 4 5 5 4 null 7
     */
    private TreeNode createTreeNode(Integer[] ii, int index) {

        if (ii == null || ii.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(ii[index]);
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;

        if (leftIndex < ii.length) {
            if (ii[leftIndex] != null) {
                root.left = createTreeNode(ii, leftIndex);
            } else {
                root.left = null;
            }
        }

        if (rightIndex < ii.length) {
            if (ii[rightIndex] != null) {
                root.right = createTreeNode(ii, rightIndex);
            } else {
                root.right = null;
            }
        }

        return root;
    }

    public static void main(String[] args) {

        String t1 = StdIn.readLine();
        String[] t1Nodes = t1.split(" ");

        TreeNode tn = new TreeNode(Integer.parseInt(t1Nodes[0]));

        if (Integer.parseInt(t1Nodes[1]) != 0) {
            tn.left = new TreeNode(Integer.parseInt(t1Nodes[1]));
        }

        if (Integer.parseInt(t1Nodes[2]) != 0) {
            tn.right = new TreeNode(Integer.parseInt(t1Nodes[2]));
        }

        if (Integer.parseInt(t1Nodes[3]) != 0) {
            tn.left.left = new TreeNode(Integer.parseInt(t1Nodes[3]));
        }

        if (Integer.parseInt(t1Nodes[4]) != 0) {
            tn.left.right = new TreeNode(Integer.parseInt(t1Nodes[4]));
        }

        if (Integer.parseInt(t1Nodes[5]) != 0) {
            tn.right.left = new TreeNode(Integer.parseInt(t1Nodes[5]));
        }

        if (Integer.parseInt(t1Nodes[6]) != 0) {
            tn.right.right = new TreeNode(Integer.parseInt(t1Nodes[6]));
        }

        String t2 = StdIn.readLine();
        String[] t2Nodes = t2.split(" ");

        TreeNode tn2 = new TreeNode(Integer.parseInt(t2Nodes[0]));

        if (Integer.parseInt(t2Nodes[1]) != 0) {
            tn2.left = new TreeNode(Integer.parseInt(t2Nodes[1]));
        }

        if (Integer.parseInt(t2Nodes[2]) != 0) {
            tn2.right = new TreeNode(Integer.parseInt(t2Nodes[2]));
        }

        if (Integer.parseInt(t2Nodes[3]) != 0) {
            tn2.left.left = new TreeNode(Integer.parseInt(t2Nodes[3]));
        }

        if (Integer.parseInt(t2Nodes[4]) != 0) {
            tn2.left.right = new TreeNode(Integer.parseInt(t2Nodes[4]));
        }

        if (Integer.parseInt(t2Nodes[5]) != 0) {
            tn2.right.left = new TreeNode(Integer.parseInt(t2Nodes[5]));
        }

        if (Integer.parseInt(t2Nodes[6]) != 0) {
            tn2.right.right = new TreeNode(Integer.parseInt(t2Nodes[6]));
        }

        Topic617 topic617 = new Topic617();
        TreeNode a = topic617.mergeTrees(tn, tn2);

        LinkedList<TreeNode> ll = new LinkedList<>();
        ll.add(a);

        StdOut.println();
        while (!ll.isEmpty()) {

            TreeNode node = ll.poll();

            if (node == null) {
                StdOut.print("null ");
            } else {
                StdOut.print(node.val + " ");

                if (node.left != null || node.right != null) {
                    ll.add(node.left);
                    ll.add(node.right);
                }
            }
        }

//        List<Integer> li = topic617.getBfsOrder1(a);
//
//        StdOut.println();
//        for (Integer aLi : li) {
//            StdOut.print(aLi + " ");
//        }
//
//        StdOut.println();
    }

}