package com.InterviewQuestions;


import java.util.Map;
import java.util.HashMap;

import com.linked.list.DNode;


/**
 * Question asked in ServiceNow onsite interview : Nov 2015
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 *
 * Created by Laks on 1/11/16.
 */
public class LRUCache {

    int capacity;
    Map<Integer, DNode> map = new HashMap<Integer, DNode>();
    DNode head = null;
    DNode end = null;

    public LRUCache(int capcity) {
        this.capacity = capcity;
    }

    public int get(int key) {

        if (map.containsKey(key)) {
            DNode node = map.get(key);
            remove(node);
            setHead(node);
            return node.getValue();
        }
            return -1;
    }

    private void setHead(DNode n) {

        n.setPre(null);
        n.setNext(head);

        if (head != null) {
           head.setPre(n);
        }
        head = n;

        if (end == null)
            end = head;

    }

    private void remove(DNode n) {

        if (n.getPre() != null) {
            n.getPre().setNext(n.getNext());
        }
        else {
            head = n.getNext();
        }

        if (n.getNext() == null) {
            end = n.getPre();
        }
        else {
            n.getNext().setPre(n.getPre());
        }

    }

    public void set(int key, int value) {

        if (map.containsKey(key)) {
            DNode oldNode = map.get(key);
           oldNode.setValue(value);
            remove(oldNode);
            setHead(oldNode);

        }
        else {
            DNode node = new DNode(key,value);
            if (map.size() >= capacity) {
                map.remove(end.getKey());
                remove(end);
                setHead(node);
            }
            else {
                setHead(node);
            }
            map.put(key,node);
        }
    }
}
