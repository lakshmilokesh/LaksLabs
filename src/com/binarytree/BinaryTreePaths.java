package com.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Question asked in FB interview
 *
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example, given the following binary tree:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *    5
 * All root-to-leaf paths are:
 *
 * ["1->2->5", "1->3"]
 *
 */
public class BinaryTreePaths {

    public static void main(String[] args) {

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> output = new ArrayList<String>();
        if (root == null)
            return output;
        findPaths(root,output,root.val+"");
        return output;
    }

    private void findPaths(TreeNode root, List<String> output, String s) {
        if (root.left == null && root.right == null) {
            output.add(s);
            return;
        }
        if (root.left != null) {
            findPaths(root.left,output,s+"->"+root.left.val);
        }
        if (root.right != null) {
            findPaths(root.right,output,s+"->"+root.right.val);
        }
    }
}
