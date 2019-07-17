package com.amazon;


//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

//Return a deep copy of the list.
//constant space complexity O(1) and linear time complexity O(N)
    public  class CopyListWithRandomPointer {

        class RandomListNode {
            int label;
            RandomListNode next, random;

            RandomListNode(int x) {
                this.label = x;
            }
        }

        public RandomListNode copyRandomList(RandomListNode head) {
            RandomListNode iter = head;
            RandomListNode tmp;

            while (iter != null) {
                tmp = iter.next;
                iter.next = new RandomListNode(iter.label);
                iter.next.next = tmp;
                iter = tmp;
            }

            iter = head;
            while (iter != null) {
                if (iter.random != null) {
                    iter.next.random = iter.random.next;
                }
                iter = iter.next.next;
            }

            RandomListNode dummyHead = new RandomListNode(0);
            RandomListNode copyIter = dummyHead;
            iter = head;
            while (iter != null) {
                copyIter.next = iter.next;
                copyIter = copyIter.next;
                iter.next = iter.next.next;
                iter = iter.next;
            }

            return dummyHead.next;

        }

    }

