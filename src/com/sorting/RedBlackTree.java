package com.sorting;

/**
 * Created by Laks on 1/6/16.
 *
 *
 * Height of the tree <= 2 lg N in worst case.
 *
 * Red-Black Tree is a self-balancing Binary Search Tree (BST) where every node follows following rules.
 * RedBlackTree
 * 1) Every node has a color either red or black.
 *
 * 2) Root of tree is always black.
 *
 * 3) There are no two adjacent red nodes (A red node cannot have a red parent or red child).
 *
 * 4) Every path from root to a NULL node has same number of black nodes.
 *
 * Why Red-Black Trees?
 * Most of the BST operations (e.g., search, max, min, insert, delete.. etc) take O(h) time where h is the height of
 * the BST. The cost of these operations may become O(n) for a skewed Binary tree. If we make sure that height of the
 * tree remains O(Logn) after every insertion and deletion, then we can guarantee an upper bound of O(Logn) for all
 * these operations. The height of a Red Black tree is always O(Logn) where n is the number of nodes in the tree.
 *
 */
public class RedBlackTree {

    private Node put(Node h, int key, int value) {
        if (h == null) {
            return new Node(key,value);
        }
        if (key < h.key)
            h.left = put(h.left,key,value);
        else if (key > h.key)
            h.right = put(h.right,key,value);
        else
            h.value = value;

        if (isRed(h.right) && !isRed(h.left))
            h = Node.rotateLeft(h);
        else if (isRed(h.left) && isRed(h.left.left))
            h = Node.rotateRight(h);
        else if (isRed(h.left) && isRed(h.right))
            Node.flipColors(h);
        return h;
    }


    private boolean isRed(Node n) {
        if (n == null)
            return false;
        return n.color == Color.RED;
    }
}
