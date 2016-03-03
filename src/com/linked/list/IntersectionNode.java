package com.linked.list;



/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:

    A:          a1 → a2
                       ↘
                        c1 → c2 → c3
                       ↗            
    B:     b1 → b2 → b3
 * begin to intersect at node c1.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */
public class IntersectionNode extends LinkedList{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Construct Node A");
		Node headA = createLinkedList();
		System.out.println("*********************");
		displayValues(headA);
		System.out.println("Construct Node B");
		Node headB = createLinkedList();
		System.out.println("*********************");
		displayValues(headB);
		Node Intersect = getIntersectingNode(headA,headB);
		if (Intersect != null)
			System.out.println("Intersecting Node" + Intersect.getData());
		else
			System.out.println("Intersecting Node" + Intersect);

	}

	/*
	 * Leet code rejected this code 0{n2}
	 */
	public static Node getIntersectionNode(Node headA, Node headB) {
		Node intersect = null;
		Node parse = headB;
		while (headA != null) {
			while (headB != null) {
				if (headA.getData() != null && headB.getData() !=null
						&& headA.getData().equalsIgnoreCase(headB.getData())) {
					return headA;
				}
				else {
					headB = headB.getNext();
				}
			}	
			headA = headA.getNext();
			headB = parse;
			
		}
		return intersect;

	}
	/*
	 * Code accepted by leet code.
	 */
	public static Node getIntersectingNode(Node headA, Node headB) {
		int countA = count(headA);
		int countB = count(headB);
		int diff = countA - countB;
		if (diff < 0)
			diff = diff * -1;
		
		while (diff > 0 && countA > countB) {
			headA = headA.getNext();
			diff--;
		}
		while (diff > 0 &&  countB > countA) {
			headB = headB.getNext();
			diff--;
		}
		if (diff > 0)
			return null;
		
		while (headA != null && headB != null) {
			if(headA.getData().equals(headB.getData())) {
				return headA;
			}
			else {
				headA = headA.getNext();
				headB = headB.getNext();
			}
		}
		return null;
	}

}
