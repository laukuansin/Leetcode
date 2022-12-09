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
        int curMaxAbs = Math.abs(curMax-root.val);
        int curMinAbs = Math.abs(curMin-root.val);
        max = Math.max(curMaxAbs,Math.max(curMinAbs,max));
        helper(root.left,Math.max(curMax,root.val),Math.min(curMin,root.val));
        helper(root.right,Math.max(curMax,root.val),Math.min(curMin,root.val));
    }
}