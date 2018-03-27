package com.binarytree;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;
	public int count;
	public TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}

    /*
     * Insert
     */
	public static TreeNode put(TreeNode root, int data) {
		TreeNode n = root;
		if (n == null)
			return new TreeNode(data);
		if (n.val < data)
			n.right = put(n.right, data);
		else if (n.val > data)
			n.left = put(n.left, data);
		else
			n.val = data;
        n.count = 1 + size(n.left) + size(n.right);
		return n;
	}
	
	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

    /*
     * Search for a key
     */
    public static int get(TreeNode root, int k) {
        TreeNode x = root;
        while (x!=null) {
            if(k < x.val)
                x = x.left;
            else if (k > x.val)
                x = x.right;
            else
                return x.val;
        }
        return 0;
    }

    public static int size(TreeNode x) {
        if (x == null)
            return 0;
        return x.count;
    }

    /*
     * How many keys < k
     */
    public static int rank(TreeNode x, int k) {

        while (x != null) {
            if (k < x.val)
                return rank(x.left, k);
            else if (k > x.val)
                return 1 + size(x.left) + rank(x.right, k);
            else
                return size(x.left);
        }
        return 0;
    }

    /*
     * find the largest key less than or equal to k
     */
    public static TreeNode floor(TreeNode x, int k) {

        if (x == null)
            return null;
        if (k < x.val)
            return floor(x.left,k);
        else if(k > x.val) {
            TreeNode t= floor(x.right, k);
            if (t != null)
                return t;
            else return x;

        }
        else
            return x;

    }
}

