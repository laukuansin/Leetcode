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
    int count =0,ans=0;
    
    public int KthSmallest(TreeNode root, int k) {
        if(root==null)
        {
            return 0;
        }
        KthSmallest(root.left,k);
        count++;
        if(k==count)
            ans= root.val;
        KthSmallest(root.right,k);
        
        return ans;
    }
    
    
}