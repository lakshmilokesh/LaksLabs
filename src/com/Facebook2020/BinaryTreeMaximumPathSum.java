package com.Facebook2020;

/* The time complexity of the below solution is O(n), where n is the total number of nodes in the binary
 * tree. The auxiliary space required by the program is O(h) for the call stack, where h is the height 
 * of the tree.
 */
public class BinaryTreeMaximumPathSum {
  
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return res;
    }
    public int solve(TreeNode root){
        if(root == null)return 0;
        int left = solve(root.left);
        int right = solve(root.right);
        
        int temp = Math.max(Math.max(left,right) + root.val,root.val);
        int ans = Math.max(temp,left+right+root.val);
        res = Math.max(ans,res);
        return temp;
    }
}
