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
    

    List<List<TreeNode>> levelList = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        levelOrder(root,0);
        List<Integer> result = new ArrayList<>();
        for(List<TreeNode> list : levelList)
            result.add(list.get(list.size()-1).val);
        return result;
    }
    void levelOrder(TreeNode root, int level){
        if(root==null)
            return;
        if(level>=levelList.size())
            levelList.add(new ArrayList<>());
        levelList.get(level).add(root);
        levelOrder(root.left,level+1);
        levelOrder(root.right,level+1);
    }
}
