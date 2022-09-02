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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.size()!=0)
        {
            int count = queue.size();
            long total=0;
            for(int i=0;i<count;i++)
            {
                TreeNode tmp= queue.poll();
                total+=tmp.val;
                if(tmp.right!=null)
                {
                    queue.add(tmp.right);
                }
                if(tmp.left!=null)
                {
                    queue.add(tmp.left);
                }
            }
            list.add((double)total/count);
        }
        
        return list;
    }
}