package com.facebook;

import com.binarytree.TreeNode;
/*
 * Interview question in linkedin
 */
public class SecondLargestInBST {


    public static void main(String[] args) {
        TreeNode root = null;
        TreeNode result = secondLargest(root);

        System.out.println(result.val);
    }

    private static TreeNode secondLargest(TreeNode node) {

        TreeNode prevNode=null; //2nd largest Element
        TreeNode currNode=node;
        if(currNode == null)
            return prevNode;

        while(currNode.right != null){
            prevNode=currNode;
            currNode=currNode.right;
        }
        if(currNode.left != null){
            currNode=currNode.left;
            while(currNode.right != null){
                currNode=currNode.right;
            }
            prevNode=currNode;
        }

        return prevNode;

    }
}
