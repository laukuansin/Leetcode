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
    //DFS
    /*
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        return Math.max(maxDepth(root.right),maxDepth(root.left))+1;
    }*/

    //BFS
    public int maxDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode tmp = queue.poll();
                if(tmp.right!=null)
                {
                    queue.add(tmp.right);
                }
                if(tmp.left!=null)
                {
                    queue.add(tmp.left);
                }
            }
            depth++;
        }

        return depth;
    }
}