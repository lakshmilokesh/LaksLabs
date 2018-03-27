package com.sorting;

/**
 * Created by Laks on 1/13/16.
 *
 * Red Black BST Representation
 * Red black tree search runs faster because of better balance
 */
public class Node {

    int key;
    int value;
    Node left, right;
    Color color; // Color of the parent link; Null links are black

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.color = Color.RED;
    }


    /*
     * Left Rotation
     */
    public static Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = Color.RED;
        return x;
    }


    /*
     * Right Rotation
     */
    public static Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = Color.RED;
        return x;
}

    /*
     * Flip colors
     */
    public static void flipColors(Node h) {
        h.color = Color.RED;
        h.right.color = Color.BLACK;
        h.left.color = Color.BLACK;
    }
}