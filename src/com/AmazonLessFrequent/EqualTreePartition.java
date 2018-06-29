package com.AmazonLessFrequent;

/*
 * Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which
 * have the equal sum of values after removing exactly one edge on the original tree.
 *
 * Input:
    5
   / \
  10 10
    /  \
   2   3

Output: True
Explanation:
    5
   /
  10

Sum: 15

   10
  /  \
 2    3

 * Sum: 15
 *
 * Complexity Analysis
 *
 * Time Complexity: O(N)O(N) where NN is the number of nodes in the input tree. We traverse every node.
 *
 * Space Complexity: O(N)O(N), the size of seen and the implicit call stack in our DFS.
 *
 */

import com.binarytree.TreeNode;

import java.util.Stack;

public class EqualTreePartition {

        static Stack<Integer> seen;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(10);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        System.out.println(checkEqualTree(root));
    }
        public static boolean checkEqualTree(TreeNode root) {
            seen = new Stack();
            int total = sum(root);
            seen.pop();
            if (total % 2 == 0)
                for (int s: seen)
                    if (s == total / 2)
                        return true;
            return false;
        }

        public static int sum(TreeNode node) {
            if (node == null) return 0;
            seen.push(sum(node.left) + sum(node.right) + node.val);
            return seen.peek();
        }
}
