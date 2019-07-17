package com.ebay;

/*
 * Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Given a binary tree,
 * print the top view of it. The output nodes can be printed in any order. Expected time complexity is O(n)
 *
 * A node x is there in output if x is the topmost node at its horizontal distance. Horizontal distance of left child of
 * a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.
 *
 *     1
    /     \
   2       3
  /  \    / \
 4    5  6   7
 * Top view of the above binary tree is
 * 4 2 1 3 7

        1
      /   \
    2       3
      \
        4
          \
            5
             \
               6
 * Top view of the above binary tree is
 * 2 1 3 6
 *
 */

import com.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewBinaryTree {

    private static void TopView(TreeNode root) {
        class QueueObj {
            TreeNode node;
            int hd;

            QueueObj(TreeNode node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        Map<Integer, TreeNode> topViewMap = new TreeMap<Integer, TreeNode>();

        if (root == null) {
            return;
        } else {
            q.add(new QueueObj(root, 0));
        }

        System.out.println("The top view of the tree is : ");

        // count function returns 1 if the container
        // contains an element whose key is equivalent
        // to hd, or returns zero otherwise.
        while (!q.isEmpty()) {
            QueueObj tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }

            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
            }

        }
        for (Map.Entry<Integer, TreeNode> entry : topViewMap.entrySet()) {
            System.out.print(entry.getValue().val);
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args)
    {
        /* Create following Binary Tree
            1
        / \
        2 3
        \
            4
            \
            5
            \
                6*/
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.left.right.right = new TreeNode(5);
        tree.left.right.right.right = new TreeNode(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        TopViewBinaryTree.TopView(tree);
    }
}
