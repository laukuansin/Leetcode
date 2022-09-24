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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        helper(root,targetSum,res,new ArrayList<>());
        
        return res;
    }
    
    public void helper(TreeNode root,int targetSum,List<List<Integer>> res,List<Integer> list)
    {
        if(root==null)
            return;
        if(root.left==null&&root.right==null)
        {
            if(targetSum-root.val==0)
            {
                list.add(root.val);
                res.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            
            return;
        }
        
        
        list.add(root.val);
        helper(root.left,targetSum-root.val,res,list);
        list.remove(list.size()-1);
        list.add(root.val);
        helper(root.right,targetSum-root.val,res,list);
        list.remove(list.size()-1);
    }
}