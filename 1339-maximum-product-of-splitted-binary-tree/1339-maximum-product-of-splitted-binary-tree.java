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
    int MOD = 1000000007;
    long max = Integer.MIN_VALUE;
    int total = 0;
    public int maxProduct(TreeNode root) {
        getTotal(root);
        helper(root);
        return (int)(max%MOD);
    }

    public void getTotal(TreeNode root)
    {
        if(root==null)
            return;
        getTotal(root.left);
        total+=root.val;
        getTotal(root.right);
    }

    public long helper(TreeNode root)
    {
        if(root==null)
            return 0;
        long left= helper(root.left);
        long right = helper(root.right);
        long middle = root.val+left+right;
        long productSum = (total-middle)*middle;
        max = Math.max(max,productSum);
        return middle;
    }   
}
