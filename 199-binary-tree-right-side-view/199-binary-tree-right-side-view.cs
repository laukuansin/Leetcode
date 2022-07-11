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
    public IList<int> RightSideView(TreeNode root) {
         List<int> list = new List<int>();
        if(root==null)
            return list;
        
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        
        while(queue.Count()!=0)
        {
            int size = queue.Count();
            
            for(int i=0;i<size;i++)
            {
                TreeNode tmp = queue.Dequeue();
                if(tmp.left!=null)
                {
                    queue.Enqueue(tmp.left);
                }
                if(tmp.right!=null)
                {
                    queue.Enqueue(tmp.right);
                }
                
                if(i==size-1)
                {
                    list.Add(tmp.val);
                }
            }
        }
        
        return list;
    }
}