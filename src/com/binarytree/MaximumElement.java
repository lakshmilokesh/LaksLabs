package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * With Recursion
	 * Time Complexity : o(n)
	 * Space Complexity : o(n) 
	 */
	public static int findMax(TreeNode root) {
		if (root == null)
			return 0;
		int max = root.val;
		int leftmax = findMax(root.left);
		int rightmax = findMax(root.right);
		if (leftmax > rightmax)
			max = leftmax;
		else 
			max = rightmax;
		if (root.val > max)
			max = root.val;
		return max;
		
	}

	/*
	 * Without recursion
	 */
	public static int findMaximum(TreeNode root) {
		
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		TreeNode node = root;
		int max = root.val;
		q.add(node);
		while (!q.isEmpty()) {
			node = q.poll();
			if (max < node.val)
				max = node.val;
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
				
		}
		return max;
		
	}
}
