package com.linked.list;

/**
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {


        if (head==null ||head.next==null){
            return head;
        }

        ListNode preHead=new ListNode (-1,null);

        preHead.next=head;
        ListNode run=head;


        while (run!=null && run.next!=null){

            if (run.data>run.next.data){
                // find node which is not in order
                ListNode smallNode=run.next;

                ListNode pre=preHead;

                // find position for smallNode
                while (pre.next.data<smallNode.data){
                    pre=pre.next;
                }


                ListNode temp=pre.next;
                pre.next=smallNode;

                run.next=smallNode.next;
                smallNode.next=temp;

            }
            else{
                // node is in order
                run=run.next;

            }

        }

        return preHead.next;

    }
}
