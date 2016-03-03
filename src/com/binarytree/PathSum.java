package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that
 * adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 * 
 * 
 *            5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
 * 
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean hasPathSumRecursion(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (sum == root.val && root.left == null && root.right == null)
			return true;
		return hasPathSumRecursion(root.left,sum-root.val) ||
			 hasPathSumRecursion(root.right,sum-root.val);

	}

	/*
	 * Without Recursion
	 */
    public static boolean hasPathSum(TreeNode root, int sum) {
    	
    	Queue<TreeNode> nodes = new LinkedList<TreeNode>();
    	Queue<Integer> values = new LinkedList<Integer>();
    	
    	TreeNode node = null;
    	int sumValues = 0;
    	
    	if (root == null)
    		return false;
    	
    	nodes.offer(root);
    	values.offer(root.val);
    	
    	while (!nodes.isEmpty()) {
    		node = nodes.poll();
    		sumValues = values.poll();
    		
    		if (sum == sumValues && node.left == null && node.right == null)
    			return true;
    		if (node.left != null) {
    			nodes.offer(node.left);
    			values.offer(node.left.val+sumValues);
    		}
    		if (node.right != null) {
    			nodes.offer(node.right);
    			values.offer(node.right.val+sumValues);
    		}
    	}
    	return false;
    }

}
