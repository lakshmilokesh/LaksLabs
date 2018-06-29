package com.facebook;

import com.binarytree.TreeNode;

public class SecondLargestElementBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode result = secondLargest(root);

        System.out.println(result.val);
    }

    private static TreeNode secondLargest(TreeNode node) {

        TreeNode prevNode=null; //2nd largest Element
        TreeNode currNode=node;
        if(null == currNode)
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
