package com.binarytree;

/*
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which
 * the depth of the two subtrees of every node never differ by more than 1.
 * 
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
    	if (root == null)
    		return false;
    	return Math.abs(TreeNode.maxDepth(root.left) - TreeNode.maxDepth(root.right)) <= 1 
    			&& (isBalanced(root.left)) && isBalanced(root.right);
        
    }
    
    /*
     * Is the left subtree unbalanced?” If it is indeed unbalanced, we return –1 right away.
     * Otherwise, L represents the left subtree’s depth. We then repeat the same process for
     * the right subtree’s depth (R).
     * 
     */
    public boolean isBalancedTree(TreeNode root) {
    	
    	return (maxDepth(root) == -1) ? false : true; 
        
    }
    
    private int maxDepth(TreeNode root) {
    	if (root == null)
    		return 0; 
    	int L = maxDepth(root.left);
    	if (L == -1)
    		return -1;
    	int R = maxDepth(root.right);
    	if (R == -1)
    		return -1;
    	return (Math.abs(L - R) <= 1) ? Math.max(L, R) : -1;
    	
    }
    
}
