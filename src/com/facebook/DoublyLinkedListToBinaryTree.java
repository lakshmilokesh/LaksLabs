package com.facebook;

/**
 * Objective: Given a sorted doubly linked list, convert it into Balanced binary search tree.
 *
 * Approach:
 *
 * Get the size of the Dou­bly Linked list.
 * Take left n/2 nodes and recur­sively con­struct left subtree
 * Make the mid­dle node as root and assign the left sub­tree( con­structed in step 2) to root’s left.
 * Recursively con­struct right sub­tree and link it to the the right of root made in step 3.
 *
 */
public class DoublyLinkedListToBinaryTree {

    public static Node head = null;
    public static Node tail = null;
    public static int size = 0;
    public Node root;

    public void add(int data) {
        Node n = new Node(data);
        if (head == null) {
            head = n;
            tail = n;
        } else {
            head.prev = n;
            n.next = head;
            head = n;
        }
        size++;
    }

    public Node dLLtoBST(int size) {
        if (size <= 0) {
            return null;
        }
        Node left = dLLtoBST(size / 2);
        Node root = head;
        root.prev = left;
        head = head.next;
        root.next = dLLtoBST(size-(size / 2)-1);
        return root;
    }
    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.prev);
            System.out.print(" " + root.data);
            inOrder(root.next);
        }
    }

    public void printDLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        DoublyLinkedListToBinaryTree r = new DoublyLinkedListToBinaryTree();
        r.add(9);
        r.add(8);
        r.add(7);
        r.add(6);
        r.add(5);
        r.add(4);
        r.add(3);
        r.add(2);
        r.add(1);
        Node h = head;
        System.out.println("DLL is : ");
        r.printDLL(h);
        Node x = r.dLLtoBST(size);
        System.out.println("Inorder traversal of contructed BST");
        r.inOrder(x);
    }

}

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
    
