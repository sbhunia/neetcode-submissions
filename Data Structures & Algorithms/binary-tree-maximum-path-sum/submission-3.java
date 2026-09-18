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

class Solution {
    int maxPath = -1000;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPath;
    }
    int dfs(TreeNode root){
        if(root==null)
            return 0;
        int maxPathLeft = dfs(root.left);
        int maxPathRight = dfs(root.right);

        maxPath = Math.max(maxPath, root.val);
        maxPath = Math.max(maxPath, root.val+maxPathLeft);
        maxPath = Math.max(maxPath, root.val+maxPathRight);
        maxPath = Math.max(maxPath, root.val+maxPathLeft+maxPathRight);

        // return value should consider the path to be only consisting of one branch
        int maxChild = Math.max(maxPathLeft, maxPathRight);
        return Math.max(root.val, root.val+maxChild);
        

    }
}
