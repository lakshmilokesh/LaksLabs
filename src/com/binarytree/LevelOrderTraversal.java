package com.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 *
 * Question asked in FB interview
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its bottom-up level order traversal as:
 * 
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * 
 */
public class LevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	Queue<TreeNode> current = new LinkedList<TreeNode>();
    	Queue<TreeNode> next = new LinkedList<TreeNode>();
    	List<Integer> resultSet = new ArrayList<Integer>();
    	
    	if (root == null)
    		return result;
    	
    	current.offer(root);
    	TreeNode node = null;
    	while (!current.isEmpty()) {
    		
    		node = current.poll();
    		resultSet.add(node.val);
    		
    		if (node.left != null) {
    			next.offer(node.left);
    		}
    		if (node.right != null) {
    			next.offer(node.right);
    		}
    		
    		//Moving elements in each level to current
    		if (current.isEmpty()) {
    			current = next;
    			result.add(resultSet);
    			resultSet = new ArrayList<Integer>();
    			next = new LinkedList<TreeNode>();
    		}
    	}
    	
    	//Reversing the final list
    	List<List<Integer>> reversedResult = new ArrayList<List<Integer>>();
    	for (int i = result.size()-1; i >=0; i--) {
    		reversedResult.add(result.get(i));
    	}
    
    	return reversedResult;
    }

}
