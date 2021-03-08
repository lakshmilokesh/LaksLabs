package com.Facebook2020;

import com.binarytree.TreeNode;

import java.util.*;

/*
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
 * ordered from top to bottom.
 *
 * For example:
 * Given the following binary tree,
 *
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 *
 * You should return [1, 3, 4].
 *
 * Complexity Analysis
 *
 * Time complexity : O(n).
 *
 * The differences itemized in the Algorithm section do not admit differences in the time complexity analysis between
 * the bread-first and depth-first search approaches.
 *
 * Space complexity : O(n).
 *
 * Because breadth-first search visits the tree layer-by-layer, the queue will be at its largest immediately before
 * visiting the largest layer. The size of this layer is 0.5n = O(n)0.5n=O(n) in the worst case (a complete binary tree).
 *
 */
public class BinaryTreeRightSideView {

    public static void main(String[] args) {

    }

    public List<Integer> rightSideView(TreeNode root) {

        int maxdepth = -1;
        Map<Integer,Integer> rightmostNode = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> qnode   = new LinkedList<>();
        Queue<Integer> depthq  = new LinkedList<>();

        qnode.add(root);
        depthq.add(0);

        while (!qnode.isEmpty()) {

            TreeNode node = qnode.remove();
            int depth = depthq.remove();

            if (node != null) {

                maxdepth = Math.max(depth, maxdepth);
                rightmostNode.put(depth,node.val);

                qnode.add(root.left);
                depthq.add(depth+1);
                qnode.add(root.right);
                depthq.add(depth+1);
            }
        }

        // Construct the solution based on the values that we end up with at the end.

        for (int i = 0; i < maxdepth; i++) {
            result.add(rightmostNode.get(i));
        }
        return result;

    }
}
