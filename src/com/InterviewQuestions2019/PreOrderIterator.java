package com.InterviewQuestions2019;

import java.util.Stack;

/*
 * FB
 *                1
 *
 *             2      3
 *
 *         4       5
 *
 *
 * Preorder (Root, Left, Right) : 1 2 4 5 3
 *
 */
public class PreOrderIterator {

    Stack<Node> stack;

    public PreOrderIterator(Node root) {
        stack = new Stack<Node>();
        if (root != null) {
            stack.push(root);
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
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return val;
    }

    public static void traverse(Node root) {

        if (root == null)
            return;
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);

        traverse(root);
        PreOrderIterator p = new PreOrderIterator(root);
        System.out.println("-----------------------------------");
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.next());

    }
}
