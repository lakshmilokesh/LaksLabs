package com.amazon;

/*
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as
 * the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *
 *        ___3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
 *
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5,
 * since a node can be a descendant of itself according to the LCA definition.
 */

import com.binarytree.TreeNode;

public class LCABinaryTree {

    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(5);
        t.left.left = new TreeNode(6);
        t.left.right = new TreeNode(2);
        t.left.right.left = new TreeNode(7);
        t.left.right.right = new TreeNode(4);

        t.right = new TreeNode(1);
        t.right.left = new TreeNode(0);
        t.right.right = new TreeNode(8);

        TreeNode lca = lowestCommonAncestor(t,t.left,t.left.right.right);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root == p || root == q || root == null)
            return root;
        TreeNode left = lowestCommonAncestor( root.left,  p,  q);
        TreeNode right = lowestCommonAncestor( root.right,  p,  q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;

    }
}
