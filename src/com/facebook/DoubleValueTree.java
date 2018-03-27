package com.facebook;

import com.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * With a tree write a program to double the value of each node.
 *
 */
public class DoubleValueTree {

    public static TreeNode doubleTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            n.val = n.val*n.val;
            if (n.left != null)
                q.offer(n.left);
            if (n.right != null)
                q.offer(n.right);
        }
        return root;
    }

    public static TreeNode doubleTreeRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        doubleRootValue(root);
        return root;
    }

    private static void doubleRootValue(TreeNode root) {
        root.val = root.val*root.val;
        if (root.left != null)
            doubleRootValue(root.left);
        if (root.right != null)
            doubleRootValue(root.right);
    }

}
