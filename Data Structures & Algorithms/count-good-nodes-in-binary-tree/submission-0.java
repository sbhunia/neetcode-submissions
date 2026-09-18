/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 /*
 DFS with max_path. If root.val>max path then its good. 
 */

class Solution {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, -100);
    }
    int goodNodes(TreeNode root, int pathMax){
        if(root==null)
            return 0;
        int goodCount = 0;
        if(root.val>=pathMax){
            pathMax = root.val;
            goodCount++;
        }
        goodCount+=goodNodes(root.left, pathMax);
        goodCount+=goodNodes(root.right, pathMax);
        return goodCount;
    }
}
