package com.binarytree;

/*
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 
 */
public class SymmentricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
        	return true;
        return isSymmentric(root.left, root.right);
    }
	
	private boolean isSymmentric(TreeNode leftTree, TreeNode rightTree) {

		if (leftTree == null && rightTree == null)
			return true;
		if (leftTree == null || rightTree == null)
			return false;
		if (leftTree.val != rightTree.val)
			return false;
		if (!isSymmentric(leftTree.left, rightTree.right))
			return false;
		if (!isSymmentric(leftTree.right, rightTree.left))
			return false;
		return true;
	}

}
