/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int ans=0;
    public TreeNode ConvertBST(TreeNode root) {
         if(root==null)
        { 
            return null;
        }
        ConvertBST(root.right);
        
        root.val+=ans;
        ans=root.val;
        ConvertBST(root.left);
        
        return root;
        
    }
  
}