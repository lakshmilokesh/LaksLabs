package com.amazon;

import com.binarytree.TreeNode;

/*
 * Given a binary tree, determine if it is a valid Binary Search Tree (BST).
 *
 * SOLUTION :
 * First, you must understand the difference between Binary Tree and BST. Binary tree is a
 * tree data structure in which each node has at most two child nodes. A BST is based on
 * binary tree, but with the following additional properties:
 *  - The left subtree of a node contains only nodes with keys less than the node’s key.
 *  - The right subtree of a node contains only nodes with keys greater than the node’s key.
 *  - Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



    public boolean isValidBST(TreeNode root) {
    	Integer low = null;
    	Integer high = null;
        return isValid(root, low, high);    
        
    }



	private boolean isValid(TreeNode root, Integer low, Integer high) {
		if (root == null)
			return true;
		 return(low == null || low < root.val) && (high == null || root.val < high)
				 && isValid(root.left, low,root.val)
		 && isValid(root.right, root.val, high);
	}
}