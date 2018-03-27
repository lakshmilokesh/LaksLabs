package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Search for an element in binary tree
 */
public class SearchElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean searchElement(TreeNode root, int data) {
		boolean found = false;
		if (root == null)
			return false;
		if (root.val == data) {
			found = true;
		}
		else {
			found = searchElement(root.left, data);
			if (!found) {
				found = searchElement(root.right, data);
			}
		}
		return found;
	}
	
	/*
	 * Without Recursion
	 */
	
	public static boolean searchData(TreeNode root, int data) {

		if (root == null)
			return false;
		TreeNode node = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		while (!q.isEmpty()) {
			node = q.poll();
			if (node.val == data)
				return true;
			if (node.left != null) 
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
		return false;
	}

}
