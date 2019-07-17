package com.facebook;

/*
 *  Given a BST and a range, return the sum of all numbers contained in the BST that are also within that range.
 *  What is the runtime of your solution?  
 *
 * Similar question asked in Google
 *
 * Given a Binary Search Tree (BST) and a range, count number of nodes that lie in the given range.
 *
 * Input:
 *       10
 *     /    \
 *   5       50
 *  /       /  \
 * 1       40   100
 *
 * Range: [5, 45]
 *
 * Output:  3
 *
 *
 *
 * Time complexity : O(h + k) where h is height of BST and k is number of nodes in given range.
 *
 */

import com.binarytree.TreeNode;

public class SumBSTRange {

    static int count = 0;
    static int sum = 0;
    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.left.left = new TreeNode(1);
        node.right = new TreeNode(50);
        node.right.left = new TreeNode(40);
        node.right.right = new TreeNode(100);

        int sum = getCountAndSum(node,5,45);
        System.out.println(sum);

    }
    public static int getCountAndSum(TreeNode node, int low, int high) {

        //Base case
        if(node == null)
            return 0;

        // If current node is in range, then
        // include it in count and recur for
        // left and right children of it
        if(node.val >= low && node.val <= high)
            return 1 + getCountAndSum(node.left, low, high)+
                    getCountAndSum(node.right, low, high);

            // If current node is smaller than low,
            // then recur for right child
        else if(node.val < low)
            return getCountAndSum(node.right, low, high);

            // Else recur for left child
        else
            return getCountAndSum(node.left, low, high);
    }
}

