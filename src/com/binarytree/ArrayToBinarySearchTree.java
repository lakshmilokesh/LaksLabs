package com.binarytree;


/*
 * Given an array where elements are sorted in ascending order, convert it to a
 * height balanced BST.
 */
public class ArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		
		TreeNode parent = sortArray(num,0,num.length-1);
		return parent;
	}
	
	private TreeNode sortArray(int[] num, int start, int end) {
		if(start > end)
			return null;
		int mid = (start+end)/2;
		TreeNode t = new TreeNode(num[mid]);
		t.left = sortArray(num, start, mid-1);
		t.right = sortArray(num, mid+1, end);
		return t;
	}
}
