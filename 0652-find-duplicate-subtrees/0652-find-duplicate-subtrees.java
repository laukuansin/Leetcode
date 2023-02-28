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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        HashMap<String,Integer> visited = new HashMap<>();
        dfs(root,list,visited);
        return list;
    }
    public String dfs(TreeNode root,List<TreeNode> list, HashMap<String,Integer> visited)
    {
        if(root==null)
        {
            return "";
        }
        
        String leftStr = dfs(root.left,list,visited);
        String rightStr = dfs(root.right,list,visited);
        String concatStr = root.val+"_"+leftStr+"_"+rightStr;
        System.out.println(concatStr);
        if(visited.getOrDefault(concatStr,0)==1)
        {
            list.add(root);
        }
        visited.put(concatStr,visited.getOrDefault(concatStr,0)+1);
       
        return concatStr;
    }
}