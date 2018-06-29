package com.googleMF;

public class TrieImplementation {

    Node root = new Node();
    private class Node {
        char c;
        int val;
        Node left;
        Node right;
        Node mid;


    }

    // d is the index for the string to be inserted
    public void put(String key,int value) {
        root = put(root,key, value,0);
    }

    public Node put(Node x, String key, int val, int d ) {

        char c = key.charAt(d);
        if (x == null) {
            x = new Node();
            x.c = c;
        }
        if (c < x.c)
            put(x.left,key,val,d);
        else if (c > x.c)
            put(x.right,key,val,d);
        else if (d < key.length()-1)
            put(x.mid,key,val,d+1);
        else
            x.val = val;

        return x;
    }

    public boolean contains (String key) {
        return get(key) != null;
    }

    public Integer get(String key) {
        Node x = get(root,key, 0);
        if (x == null)
            return null;
        return x.val;
    }

    public Node get (Node x, String key, int d) {
        char c = key.charAt(d);
        if (x == null) {
            return null;
        }
        if (c < x.c)
            get(x.left,key,d);
        else if (c > x.c)
            get(x.right,key,d);
        else if (d < key.length()-1)
            get(x.mid,key,d+1);
        return x;
    }
}
