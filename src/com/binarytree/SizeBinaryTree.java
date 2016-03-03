package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SizeBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * With Recursion
	 * Time Complexity : o(n)
	 * Space Complexity : o(n) 
	 */
	public static int size(TreeNode root) {
		if(root == null)
			return 0;
		return size(root.left) + size(root.right) + 1;
	}

	public static int sizeOfTree(TreeNode root) {
		if(root == null)
			return 0;
		TreeNode node = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		int count = 0;
		while (!q.isEmpty()) {
			q.poll();
			count++;
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
		return count;
	}
}
