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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        if(root.left==null&&root.right==null)
        {
            if(targetSum-root.val==0)
            {
                return true;
            }
        }
       boolean check1=false;
        boolean check2=false;
        if(root.left!=null)
            check1=hasPathSum(root.left,targetSum-root.val);
        if(root.right!=null)
            check2=hasPathSum(root.right,targetSum-root.val);
        
        return check1||check2;
    }
    
}