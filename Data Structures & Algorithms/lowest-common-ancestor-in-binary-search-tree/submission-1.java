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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {       
        if(root == null || p==null || q==null)
            return null;
        if(p.val>q.val){
            TreeNode temp = p;
            p=q;
            q=temp;
        }
        /*
        idea is that when p.val <= root.val <= q.val
        */
        if(p.val<=root.val){
            if(q.val<root.val)
                return lowestCommonAncestor(root.left, p, q);
            else
                return root;
            
        }else
            return lowestCommonAncestor(root.right, p, q);
    }
}
