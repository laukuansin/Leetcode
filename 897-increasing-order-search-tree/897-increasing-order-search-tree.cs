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
    public TreeNode IncreasingBST(TreeNode root) {
        if(root==null)
        {
            return null;
        }
        Stack<int> stack = new Stack<int>();
        helper(root,stack);
        TreeNode newTree=new TreeNode(0,null,null);
        TreeNode trackTree = newTree;
       
        while(stack.Count()>0)
        {
            int val = stack.Pop();
            TreeNode tmp = new TreeNode(val);
            trackTree.right=tmp;
            trackTree=trackTree.right;
        }
        return newTree.right;
    }
    
    public void helper(TreeNode root, Stack<int> stack)
    {
        if(root==null)
        {
            return;
        }
        helper(root.right,stack);
        stack.Push(root.val);
        helper(root.left,stack);
        
        return;
    }
}