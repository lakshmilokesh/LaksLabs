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

    public static void main(String[] args) {

    }
    public static int getCountAndSum(TreeNode node, int low, int high, int count, int sum) {

        //Base case
        if (node == null)
            return 0;

        // this node lies in range, if yes, then add 1 to result (count) or add he value of the node to the sum and
        // recur for both of its children.
        if (node.val >= low && node.val <= high) {
            count++;
            sum+=node.val;
        }

        //If current node is smaller than low value of range, then recur for right child, else recur for left child.
        else if(node.val > high)
            getCountAndSum(node.left,low,high,count,sum);
        else {
            getCountAndSum(node.right,low,high,count,sum);
        }
      return sum;
    }
}

