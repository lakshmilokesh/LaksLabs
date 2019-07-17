package com.AmazonLessFrequent;

/*
 * Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf
 * node to target k in the tree.
 *
 * Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree.
 * Also, a node is called a leaf if it has no children.
 *
 * In the following examples, the input tree is represented in flattened form row by row. The actual root tree given
 * will be a TreeNode object.
 *
 * Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2

Output: 2 (or 3)

Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
 *
 * https://www.geeksforgeeks.org/closest-leaf-to-a-given-node-in-binary-tree/
 *
 */

import com.binarytree.TreeNode;

public class ClosestLeafBinaryTree {

    // NOT THE RIGHT SOLUTION
    public int findClosestLeaf(TreeNode root, int target) {

        int ret = 0;
        while(root != null){
            ret = root.val;
            if(Math.abs(target - root.val) < Math.abs(target - ret) && root.left == null && root.right == null){
                ret = root.val;
            }
            root = root.val > target? root.left: root.right;
        }
        return ret;
    }
}
