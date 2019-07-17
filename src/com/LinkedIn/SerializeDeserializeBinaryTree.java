package com.LinkedIn;

/*
 *Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
 * to a string and this string can be deserialized to the original tree structure.
 *
 * For example, you may serialize the following tree
 *
 *        1
 *       / \
 *      2   3
 *     / \
 *    4   5
 *
 *  as "[1,2,3,null,null,4,5]"
 *
 *
 *  SOLUTION : One advantage of using BFS is we could safely removing the trailing last-level null nodes represented by
 *  the "#," string. This can save about half space (The # nodes in last-level of a binary tree is around half of the
 *  total number of trees).
 *
 * By BFS: the serialized tree is 1,2,3,4
 * By DFS, the serialized tree is 1,2,4,#,#,#,3, which needs more space to store.
 *
 */

import com.binarytree.TreeNode;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        SerializeDeserializeBinaryTree obj = new SerializeDeserializeBinaryTree();
        obj.deserialize(obj.serialize(root));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        StringBuffer sb = new StringBuffer();

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                sb.append(curr.val + ",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                sb.append("#" + ",");
            }
        }

        // Remove the trailing #
        String result = sb.toString();
        System.out.println("1111  =>"+ result);
        int j = result.length() - 1;
        System.out.println("length  =>"+ j);

        while (j > 1 && result.charAt(j) == ',' && result.charAt(j-1) == '#') {
            j -= 2;
        }
        System.out.println(j);

        result = result.substring(0, j);
        System.out.println(result);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodes = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int i = 1;

        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode curr = queue.poll();
            if (nodes[i].equals("#")) {
                curr.left = null;
            } else {
                TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[i]));
                curr.left = leftNode;
                queue.offer(leftNode);
            }

            i++;
            if (i >= nodes.length) {
                break;
            }

            // right node
            if (nodes[i].equals("#")) {
                curr.right = null;
            } else {
                TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[i]));
                curr.right = rightNode;
                queue.offer(rightNode);
            }

            i++;
        }

        return root;
    }
}
