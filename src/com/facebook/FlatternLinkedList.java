package com.facebook;

/**
 * Given a linked list where every node represents a linked list and contains two pointers of its type:
 * (i) Pointer to next node in the main list (we call it ‘right’ pointer in below code)
 * (ii) Pointer to a linked list where this node is head (we call it ‘down’ pointer in below code).
 * All linked lists are sorted. See the following example
 *
 * 5 -> 10 -> 19 -> 28
 * |    |     |     |
 * V    V     V     V
 * 7    20    22    35
 * |          |     |
 * V          V     V
 * 8          50    40
 * |                |
 * V                V
 * 30               45
 * Write a function flatten() to flatten the lists into a single linked list. The flattened linked list should also be
 * sorted. For example, for the above input list, output list should be 5->7->8->10->19->20->22->28->30->35->40->45->50.
 *
 *
 */
public class FlatternLinkedList {

        private static MultiNode<Integer> merge(MultiNode<Integer> a, MultiNode<Integer> b) {
            MultiNode<Integer> head = new MultiNode<Integer>();
            MultiNode<Integer> temp = head;
            while (a != null && b != null) {
                if (a.data < b.data) {
                    temp.down = a;
                    temp = temp.down;
                    a = a.down;
                } else if (b.data < a.data) {
                    temp.down = b;
                    temp = temp.down;
                    b = b.down;
                }
            }

            temp.down = (a == null) ? b : a;
            return head.down;
        }

        static class MultiNode<T> {
            T data;
            MultiNode<T> right;
            MultiNode<T> down;

            public MultiNode(T data) {
                this.data = data;
            }

            public MultiNode() {

            }
        }

        public static MultiNode<Integer> flatten(MultiNode<Integer> root) {

            MultiNode<Integer> temp = root;
            MultiNode<Integer> result = null;
            while (temp != null) {
                result = merge(temp, result);
                temp = temp.right;
            }
            return result;
        }

        public static void print(MultiNode<Integer> start) {
            while (start != null) {
                System.out.print(start.data+" ");
                start = start.down;
            }
        }

        public static void main(String[] args) {
            MultiNode<Integer> start = new MultiNode<Integer>(5);
            start.right = new MultiNode<Integer>(10);
            start.right.right = new MultiNode<Integer>(19);
            start.right.right.right = new MultiNode<Integer>(28);

            start.down = new MultiNode<Integer>(7);
            start.down.down = new MultiNode<Integer>(8);
            start.down.down.down = new MultiNode<Integer>(30);

            start.right.down = new MultiNode<Integer>(20);

            start.right.right.down = new MultiNode<Integer>(22);
            start.right.right.down.down = new MultiNode<Integer>(50);

            start.right.right.right.down = new MultiNode<Integer>(35);
            start.right.right.right.down.down = new MultiNode<Integer>(40);
            start.right.right.right.down.down.down = new MultiNode<Integer>(45);
            // Node result = flatten(start);
            MultiNode<Integer> result = flatten(start);
            print(result);
        }
    }

