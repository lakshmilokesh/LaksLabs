package com.LinkedIn;

import com.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



/*
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 
 *  3
 * / \
 * 9  20
 *  /  \
 *  15   7
 *
 * Should return
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class BinaryTreeZigzagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<Integer> resultSet = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Queue<TreeNode> current =  new LinkedList<TreeNode>();
		Queue<TreeNode> next = new LinkedList<TreeNode>();
		boolean reverse = false;

		if (root == null)
			return result;

		current.offer(root);
		while (!current.isEmpty()) {
			TreeNode node = current.poll();
			resultSet.add(node.val);

			if (node.left != null)
				next.offer(node.left);
			if (node.right != null)
				next.offer(node.right);



			if (current.isEmpty()) {
				current = next;
				// Reverse based on the flag "reverse"
				if (reverse) {
					Collections.reverse(resultSet);
					reverse = false;
				}
				else {
					reverse = true;
				}
				result.add(resultSet);
				resultSet = new ArrayList<Integer>();
				next = new LinkedList<TreeNode>();
			}
		}
		return result;
	}

}
