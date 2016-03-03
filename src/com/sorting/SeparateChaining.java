package com.sorting;

/**
 * Created by Laks on 1/13/16.
 *
 *
 */
public class SeparateChaining {

    private int n = 97;
    private Node[] st = new Node[n];

    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value, Node node) {
            this.key = key;
            this.value = value;
            this.next = node; //doubtful about this
        }
    }

    public Object get(Object key) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put (Object key, Object value) {
        int i = hash(key);
        for (Node x = st[i]; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        st[i] = new Node(key,value,st[i]);
    }

    private int hash(Object key) {
        return key.hashCode();
    }
}
