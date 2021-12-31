package com.AmazonLessFrequent;

/*
 * Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf
 * node to target k in the tree.
 *
 * Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree.
 * Also, a node is called a leaf if it has no children.
 *
 * In the following examples, the input tree is represented in flattened form row by row. The actual root tree given
 * will be a TreeNode object.
 *
 * Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2

Output: 2 (or 3)

Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
 *
 * https://www.geeksforgeeks.org/closest-leaf-to-a-given-node-in-binary-tree/
 *
 */

import com.binarytree.TreeNode;
 /**
 2  * Definition for a binary tree node.
 3  * public class TreeNode {
 4  *     int val;
 5  *     TreeNode left;
 6  *     TreeNode right;
 7  *     TreeNode() {}
 8  *     TreeNode(int val) { this.val = val; }
 9  *     TreeNode(int val, TreeNode left, TreeNode right) {
10  *         this.val = val;
11  *         this.left = left;
12  *         this.right = right;
13  *     }
14  * }
15  */
16 class Solution {
17     TreeNode target;
18 
19     public int findClosestLeaf(TreeNode root, int k) {
20         HashMap<TreeNode, TreeNode> map = new HashMap<>();
21         dfs(root, null, map, k);
22         if (target == null) {
23             return -1;
24         }
25 
26         Queue<TreeNode> queue = new LinkedList<>();
27         HashSet<Integer> visited = new HashSet<>();
28         queue.offer(target);
29         visited.add(k);
30         while (!queue.isEmpty()) {
31             TreeNode cur = queue.poll();
32             if (cur.left == null && cur.right == null) {
33                 return cur.val;
34             }
35             if (cur.left != null && !visited.contains(cur.left.val)) {
36                 queue.offer(cur.left);
37                 visited.add(cur.left.val);
38             }
39             if (cur.right != null && !visited.contains(cur.right.val)) {
40                 queue.offer(cur.right);
41                 visited.add(cur.right.val);
42             }
43             if (map.containsKey(cur) && !visited.contains(map.get(cur).val)) {
44                 queue.offer(map.get(cur));
45                 visited.add(map.get(cur).val);
46             }
47         }
48         return -1;
49     }
50 
51     private void dfs(TreeNode root, TreeNode parent, HashMap<TreeNode, TreeNode> map, int k) {
52         if (root == null) {
53             return;
54         }
55         if (parent != null) {
56             map.put(root, parent);
57         }
58         if (root.val == k) {
59             target = root;
60         }
61         dfs(root.left, root, map, k);
62         dfs(root.right, root, map, k);
63     }
64 }


   
    

     
    
        
         
            
     
