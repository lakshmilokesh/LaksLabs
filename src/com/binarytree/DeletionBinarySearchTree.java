package com.binarytree;

/**
 * Created by Laks on 8/4/17.
 */
public class DeletionBinarySearchTree {

    /*
     * Minimum element is the leftmost element in a tree
     */
    public static TreeNode deleteMinimum(TreeNode root) {
        TreeNode x = root;
        if (x == null)
            return null;
        if (x.left == null)
            return x.right;
        x.left =  deleteMinimum(x.left);
        x.count = 1 + TreeNode.size(x.left) + TreeNode.size(x.right);
        return x;
    }

    /*
     * Delete a key
     */

    public static TreeNode delete(TreeNode x, int k) {

        if (x == null)
            return null;
        if (k < x.val)
            return delete(x.left,k);
        else if (k > x.val)
            return delete(x.right,k);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            TreeNode t = x;
            //x = min(t);
            x.right = deleteMinimum(t.right);
            // logic is find the minimum in the right sub tree
            // and swap it with the key to be deleted
            x.left = t.left;
        }
        x.count = 1 + TreeNode.size(x.left) + TreeNode.size(x.right);
        return x;
    }
}
