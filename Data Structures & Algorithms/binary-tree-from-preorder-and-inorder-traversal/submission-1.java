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
    int[] preorder, inorder;
    int preL = 0;
    Map<Integer,Integer> inIndex = new HashMap<Integer, Integer>(); 

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        this.inorder=inorder;
        for(int i=0; i<inorder.length; i++)
            inIndex.put(inorder[i], i);
        return buildTree(0, preorder.length-1);
    }
    TreeNode buildTree(int inL, int inR){
        if(inL > inR | inR > inorder.length-1 | inL < 0) // i.e the arrays are empty
            return null;
        int rVal = preorder[preL++];
        int cutIndex = inIndex.get(rVal);
        
        TreeNode lChild = buildTree(inL, cutIndex-1);
        TreeNode rChild = buildTree(cutIndex+1, inR); 
        return new TreeNode(rVal, lChild, rChild);
    }
}
