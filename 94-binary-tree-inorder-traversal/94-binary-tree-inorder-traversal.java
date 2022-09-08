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
    List<Integer> list;
    public List<Integer> inorderTraversal(TreeNode root) {
        list=new ArrayList<>();
        if(root==null)
            return list;
        helper(root);
        return list;
    }
    public void helper(TreeNode root)
    {
        if(root==null)
            return;
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}