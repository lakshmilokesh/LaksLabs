package com.binarytree;

import java.util.Stack;

/*
 *
 *                1
 *
 *             2      3
 *
 *         4       5
 *             6
 *
 *
 * Inorder (Left, Root, Right) : 4 2 6 5 1 3
 *
 * Facebook Phone Interview 2019
 *
 *
 *
 *
 */

public class InorderIterator {


    Stack<Node> stack;

    private static class Node {
        int val;
        Node left;
        Node right;
    }

    public InorderIterator(Node root) {
        stack = new Stack<Node>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {

        int val = -1;
        if (stack != null) {
            Node node = stack.pop();
            val = node.val;
            while (node.right != null) {
                node = node.right;
                stack.push(node);
                node = node.left;
            }
        }
        return val;
    }

    public static void main(String[] args) {

//s

    }
}
