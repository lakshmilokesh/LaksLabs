package com.InterviewQuestions;

import com.binarytree.TreeNode;

import java.util.Stack;

/**
 * Created by Laks on 1/21/16.
 *
 * Question asked for Sahitya in Oracle Interview 2015
 *
 * Problem
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST. Note: next() and hasNext() should run in average
 * O(1) time and uses O(h) memory, where h is the height of the tree.
 */
public class TreeIterator {

    Stack<TreeNode> stack;

    public TreeIterator(TreeNode root) {
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
