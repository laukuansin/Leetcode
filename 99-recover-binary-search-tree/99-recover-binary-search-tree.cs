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
    TreeNode pre = null, one = null, two =null;
    public void RecoverTree(TreeNode root) {
        inorder(root);
        
        int temp = one.val;
        one.val=two.val;
        two.val=temp;
    }
    
    public void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        if(pre!=null)
        {
            if(pre.val>root.val)
            {
                
                two=root;
                if(one==null)
                {
                    one=pre;
                   
                }
                else{
                    return;
                }
                
            }
        }
        pre=root;
        inorder(root.right);
        
    }
}