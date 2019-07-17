package com.LinkedIn;

import com.binarytree.TreeNode;

import java.util.Stack;

/**
 * Created by Laks on 1/21/16.
 *
 * Question asked  in Oracle Interview 2015 (Facebook/Google)
 *
 * Problem
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST. Note: next() and hasNext() should run in average
 * O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 * So this can satisfy O(h) memory, hasNext() in O(1) time,
 * But next() is O(h) time.
 *
 *
 */
public class BinarySearchTreeIterator {

    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        if (node.right != null) {
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return val;
    }
}
