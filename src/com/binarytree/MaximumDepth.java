package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * With Recursion
	 */
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
	}
	
	/*
	 * Without Recursion
	 */
	public int maximumDepth(TreeNode root) {
		if(root == null)
			return 0;
		TreeNode node = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		int level = 1;
		q.add(node);
		q.add(null);
		while (!q.isEmpty()) {
			node = q.poll();
			if (node == null) {
				if (!q.isEmpty()) {
					q.add(null);
				}
				level++;
			}
			else {
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
		}
		return level;
	}
}
