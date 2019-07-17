package com.linked.list;

import com.linked.list.LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Partition a linked list around a value x, such that all nodes less than x come before all nodes greater 
 * than or equal to x.
 */
public class PartitionLinkedList extends LinkedList {

	private static Node Lefthead = null;
	private static Node rightHead = null;
	private static Node xNode = null;

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		Node head = createLinkedList();
		displayValues(head);
		
		System.out.println("Enter the partition data");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		//partition(head, Integer.parseInt(str));
	}

	public static ListNode partition(ListNode head, int x) {
		ListNode dummy1 = new ListNode(0,null), dummy2 = new ListNode(0,null);  //dummy heads of the 1st and 2nd queues
		ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
		while (head!=null){
			if (head.data<x) {
				curr1.next = head;
				curr1 = curr1.next;
			}else {
				curr2.next = head;
				curr2 = curr2.next;
			}
			head = head.next;
		}
		curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
		curr1.next = dummy2.next;
		return dummy1.next;

	}


}
