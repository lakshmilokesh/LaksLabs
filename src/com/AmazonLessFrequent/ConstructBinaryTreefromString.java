package com.AmazonLessFrequent;

import com.binarytree.TreeNode;

import java.util.Stack;

public class ConstructBinaryTreefromString {

    public static void main(String[] args) {

        String s = "4(2(3)(1))(6(5))";
        str2tree2(s);

    }

    public static TreeNode str2tree2(String s) {
        if (s == null || s.length() == 0)
            return null;
        if (s.indexOf("(") < 0)
            return new TreeNode(Integer.valueOf(s));
        int index = -1;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                if (index + 1 < i) {
                    int num = Integer.parseInt(s.substring(index + 1, i));
                    TreeNode cur = new TreeNode(num);
                    if (!stack.isEmpty()) {
                        TreeNode parent = stack.peek();
                        if (parent.left == null)
                            parent.left = cur;
                        else
                            parent.right = cur;
                    }
                    stack.push(cur);
                }
                if (c == ')')
                    stack.pop();
                index = i;
            }
        }

        return stack.isEmpty() ? null : stack.peek();
    }
}
