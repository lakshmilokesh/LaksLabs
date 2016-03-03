package com.linked.list;

/**
 *
 * Doubly Linked List
 * Created by Laks on 1/11/16.
 */
public class DNode {

    private int key;
    private int value;
    private DNode pre;
    private DNode next;

    public DNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.pre = null;
        this.next = null;
    }
    public DNode getNext() {
        return next;
    }

    public void setNext(DNode next) {
        this.next = next;
    }

    public DNode getPre() {
        return pre;
    }

    public void setPre(DNode pre) {
        this.pre = pre;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }


}
