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
    private void levelOrder(TreeNode root, int level, List<List<Integer>> llist ){
        if(root==null)
            return;
        if(llist.size()<=level)
            llist.add(new ArrayList<Integer>());
        
        llist.get(level).add(root.val);
        levelOrder(root.left, level+1, llist );
        levelOrder(root.right, level+1, llist );
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> llist= new ArrayList<List<Integer>>();
        levelOrder(root,  0, llist );
        return llist;
    }
}
