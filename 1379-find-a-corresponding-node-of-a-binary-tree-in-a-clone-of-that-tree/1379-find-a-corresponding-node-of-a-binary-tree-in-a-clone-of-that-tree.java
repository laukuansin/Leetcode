/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ansNode,target;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original==null||cloned==null)
        {
            return null;
        }
        this.target=target;
        helper(original,cloned);
        return ansNode;
    }
    
    public void helper(TreeNode ori,TreeNode clo)
    {
        if(ori==null)
        {
            return;
        }
        helper(ori.left,clo.left);
        if(ori==target)
        {
            ansNode=clo;
        }
        helper(ori.right,clo.right);
    }
    
}