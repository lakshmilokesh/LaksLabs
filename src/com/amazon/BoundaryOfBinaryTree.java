package com.amazon;

/*
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary
 * includes left boundary, leaves, and right boundary in order without duplicate nodes.
 *
 * Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from
 * root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left
 * boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any
 * subtrees.
 *
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if
 * exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
 *
 * The right-most node is also defined by the same way with left and right exchanged.
 *
 * Input:
 *  1
 *  \
 *   2
 *  / \
 *  3   4
 *
 * Ouput:
 * [1, 3, 4, 2]
 *
 * Explanation:
 * The root doesn't have left subtree, so the root itself is left boundary.
 * The leaves are node 3 and 4.
 * The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
 * So order them in anti-clockwise without duplicates and we have [1,3,4,2].
 *
 *
 * Complexity Analysis
 *
 * Time complexity : O(n)O(n) One complete traversal for leaves and two traversals upto depth of binary tree for left
 * and right boundary.
 *
 * Space complexity : O(n)O(n) resres and stackstack is used.
 *
 */

import com.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTree {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;
        if (!isLeaf(root))
            result.add(root.val);
        TreeNode t = root.left;
        while(t != null) {
            if (!isLeaf(t)) {
                result.add(t.val);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }
        }

        addLeaves(result, root);
        Stack<Integer> s = new Stack<>();
        t = root.right;
        while (t != null) {
            if (!isLeaf(t)) {
                s.push(t.val);
            }
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        while (!s.empty()) {
            result.add(s.pop());
        }
        return result;

    }

    public static boolean isLeaf (TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void addLeaves(List<Integer> res, TreeNode root) {
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            if (root.left != null) {
                addLeaves(res, root.left);
            }
            if (root.right != null) {
                addLeaves(res, root.right);
            }
        }
    }
}
