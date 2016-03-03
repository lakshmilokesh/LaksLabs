package com.binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * 
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two
 * nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be
 * a descendant of itself).”
 *
 *      _______6______
 *     /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of
 * nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * 
 */
public class LowestCommonAncestor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		TreeNode root = null,q = null,p = null;
		System.out.println("Constructing root");
		int i = 0;
		while (true) {
			root = constructTree(root);
			i++;
			if (i == 9)
				break;
		}
		
		System.out.println("Constructing p");
		i = 0;
		while (true) {
			p = constructTree(p);
			i++;
			if (i == 5)
				break;
		}
		
		System.out.println("Constructing q");
		i = 0;
		while (true) {
			q = constructTree(q);
			i++;
			if (i == 3)
				break;
		}
		
		TreeNode value = lowestCommonAncestor(root, p, q);
		System.out.println("LCA -> " + value.val);
	}



	private static TreeNode constructTree(TreeNode node) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter String");
		String str1 = br.readLine();
		node = TreeNode.put(node,Integer.valueOf(str1).intValue());

		return node;
	}



	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode n = root;

		if (n.val > p.val && n.val < q.val) 
			return n;
		
		else if (n.val > p.val && n.val > q.val) 
			return lowestCommonAncestor(n.left, p, q); // then the value is in the left side of the tree
		
		else if (n.val < p.val && n.val < q.val)
			return lowestCommonAncestor(n.right, p, q); //  then the value is in the right side of the tree

		return n; // equals case either p or q is equal to m
	}

}
