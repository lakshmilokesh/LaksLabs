package com.Facebook2020;

/*
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:

Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4
 *
 *
 */

import com.binarytree.TreeNode;

public class ClosestBinarySearchTreeValue {

    public static int closestValue(TreeNode root, double target) {
        int ret = root.val;;
        while(root != null){

            if(Math.abs(target - root.val) < Math.abs(target - ret)){
                ret = root.val;
            }
            root = root.val > target? root.left: root.right;
        }
        return ret;
    }

    public static void main(String[] args) {

        TreeNode node = new TreeNode(4);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        System.out.println(closestValue(node,3.714286));


    }
}
