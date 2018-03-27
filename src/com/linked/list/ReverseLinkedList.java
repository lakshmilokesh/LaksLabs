package com.linked.list;

import com.linked.list.LinkedList.Node;

/**
 * Create a linked list with 3 char (A,B,C) in it and print the list in reverse.
 *
 * Question asked in FB interview
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        Node head = create(3);
        LinkedList.displayValues(head);
        LinkedList.displayValues(recursionReverse(head));
    }

    //Iterative approach
    public static Node reverse(Node headA) {

        if (headA == null)
            return null;
        Node current = headA;
        Node previous = null;
        Node next = null;
        Node head = null;
        while (current.next != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = current;
        current.next = previous;
        return head;
    }

    public static Node create(int count) {
        int i = 1;
        Node head = new LinkedList().new Node("A",null);
        Node current = head;
        while (i < count){
            Node newNode = new LinkedList().new Node(String.valueOf((char)('A'+i)),null);
            current.next = newNode;
            current = current.next;
            i++;
        }
        return head;
    }

    //Recursive approach
    public static Node recursionReverse(Node head) {
        head = reverseNodes(null, head);
        return head;
    }

    private static Node reverseNodes(Node prevNode, Node currentNode) {
        if (currentNode == null)
            return prevNode;
        Node nextNode = currentNode.next;
        currentNode.next = prevNode;
        return reverseNodes(currentNode, nextNode);
    }

}
