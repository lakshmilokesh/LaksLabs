package com.sorting;

/**
 * Created by Laks on 1/6/16.
 *
 *
 * Height of the tree <= 2 lg N in worst case.
 */
public class RedBlackTree {

    private Node put(Node h, int key, int value) {
        if (h == null) {
            return new Node(key,value);
        }
        if (key < h.key)
            put(h.left,key,value);
        else if (key > h.key)
            put(h.right,key,value);
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
