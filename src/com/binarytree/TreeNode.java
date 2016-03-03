package com.binarytree;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) {
		val = x;
	}
	
	public static TreeNode put(TreeNode root, int data) {
		TreeNode n = root;
		if (n == null)
			return new TreeNode(data);
		if (n.val < data)
			n.right = put(n.right, data);
		else if (n.val > data)
			n.left = put(n.left, data);
		else
			n.val = data;
		return n;
	}
	
	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}

