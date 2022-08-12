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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
    
        if(root.left!=null)
        {
            if((root==p&&root.left==q)||(root==q&&root.left==p))
            {
                return root;
            
            }
            else if(root.val>p.val&&root.val>q.val)
            {
                return lowestCommonAncestor(root.left,p,q);
            }
        }
        if(root.right!=null)
        {
            if((root==p&&root.right==q)||(root==q&&root.right==p))
            {
                return root;
            }
            else if(root.val<p.val&&root.val<q.val)
            {
                return lowestCommonAncestor(root.right,p,q);
            }
        }return root;
    }
  
}