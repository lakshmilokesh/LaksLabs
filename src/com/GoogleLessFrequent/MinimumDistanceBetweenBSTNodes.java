package com.GoogleLessFrequent;

/*
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two
 * different nodes in the tree.

Example :

Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \
    1   3

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 *
 *
 *
 */

import com.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumDistanceBetweenBSTNodes {

    static List<Integer> vals;
    static Integer res;
    static Integer prev;

    public static int minDiffInBSTBetter(TreeNode root) {
        res = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return res;
    }

    public static void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        if(prev !=  null){
            res = Math.min(res, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
    }

    public static int minDiffInBST(TreeNode root) {
        vals = new ArrayList();
        dfs(root);
        Collections.sort(vals);

        for (int i : vals) {
            System.out.println(i);
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < vals.size() - 1; ++i)
            ans = Math.min(ans, vals.get(i+1) - vals.get(i));

        return ans;
    }

    public static void dfs(TreeNode node) {
        if (node == null) return;
        vals.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(minDiffInBSTBetter(root));

    }
}
