package com.AmazonLessFrequent;

/*
 * Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum
 * width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in
 * the level, where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * Input:

           1
         /   \
        3     2
       / \     \
      5   3     9

 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 *
 * Input:

          1
         /
        3
       / \
      5   3

 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 *
 *
 * Complexity Analysis
 *
 * Time Complexity: O(N) where N is the number of nodes in the input tree. We traverse every node.
 *
 * Space Complexity: O(N), the size of our queue.
 *
 */

import com.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthofBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {
        Queue<AnnotatedNode> queue = new LinkedList();
        queue.add(new AnnotatedNode(root, 0, 0));
        int curDepth = 0, left = 0, ans = 0;
        while (!queue.isEmpty()) {
            AnnotatedNode a = queue.poll();
            if (a.node != null) {

                // if parent is at position p then the child will be at location 2p and 2p+1
                queue.add(new AnnotatedNode(a.node.left, a.depth + 1, a.pos * 2));
                queue.add(new AnnotatedNode(a.node.right, a.depth + 1, a.pos * 2 + 1));
                if (curDepth != a.depth) {
                    curDepth = a.depth;
                    left = a.pos;
                }
                ans = Math.max(ans, a.pos - left + 1);
            }
        }
        return ans;
    }
}

class AnnotatedNode {
    TreeNode node;
    int depth, pos;
    AnnotatedNode(TreeNode n, int d, int p) {
        node = n;
        depth = d;
        pos = p;
    }

}
