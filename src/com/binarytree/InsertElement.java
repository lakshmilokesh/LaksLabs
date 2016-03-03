package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	/*
	 * Without Recursion
	 */
	
	public static void insertElement(TreeNode root, int data) {

		TreeNode newNode = new TreeNode(data);
		
		if (root == null) {
			root = newNode;
			return;
		}
		TreeNode node = root;
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(node);
		while (!q.isEmpty()) {
			node = q.poll();
			if (node.left == null) {
				node.left = newNode;
				return;
			}
			else {
				q.add(node.left);
			}
			if (node.right == null) {
				node.right = newNode;
				return;
			}
			else {
				q.add(node.right);
			}
		}
	}
	/*
	 * With Recursion
	 */
	public static void insertElementRecursion(TreeNode root, int data) {

		TreeNode node = new TreeNode(data);
		if (root == null) {
			root = node;
			return;
		}

		insertElementRecursion(root.left,data);
		insertElementRecursion(root.right,data);

	}

}
