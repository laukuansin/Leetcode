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
    long num = Long.MIN_VALUE;
    boolean check=true;
    public boolean isValidBST(TreeNode root) {
        
        helper(root);
        return check;
    }
    
    public void helper(TreeNode root)
    {
        if(root==null)
            return;
        
        isValidBST(root.left);
        if(num>=root.val)
        {
            check=false;
            return;
        }
        num=root.val;
        isValidBST(root.right);
    }
}