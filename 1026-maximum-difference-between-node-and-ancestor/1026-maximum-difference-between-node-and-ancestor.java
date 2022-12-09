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
    int max = Integer.MIN_VALUE;
    
    public int maxAncestorDiff(TreeNode root) {
        helper(root,root.val,root.val);
        return max;
    }
    
    public void helper(TreeNode root,int curMax,int curMin)
    {
        if(root==null)
            return;
        
        int curMaxAbs = Math.abs(curMax-root.val);//get the difference from the current Min and current value
        int curMinAbs = Math.abs(curMin-root.val);//get the difference from th current Max and current value
        max = Math.max(curMaxAbs,Math.max(curMinAbs,max));//get the maximum difference between these 3 value
        helper(root.left,Math.max(curMax,root.val),Math.min(curMin,root.val));//rercusive left node
        helper(root.right,Math.max(curMax,root.val),Math.min(curMin,root.val));//recursive right node
    }
}