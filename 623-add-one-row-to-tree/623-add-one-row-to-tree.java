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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root==null)
            return null;
        if(depth==1)
        {
            TreeNode treeNode = new TreeNode(val);
            treeNode.left=root;
            return treeNode;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //TreeNode tmp = root;
        int curDepth=1;
        queue.add(root);
        
        while(queue.size()!=0)
        {
            int size = queue.size();
            
            
            for(int i=0;i<size;i++)
            {
                TreeNode tmp = queue.poll();
                TreeNode tmpLeft = null;
                TreeNode tmpRight = null;
                if(tmp.left!=null)
                {
                    queue.add(tmp.left);
                    tmpLeft=tmp.left;
                }
                if(tmp.right!=null)
                {
                    queue.add(tmp.right);
                    tmpRight=tmp.right;
                }
                if(curDepth==depth-1)
                {
                    TreeNode left = new TreeNode(val);
                    TreeNode right = new TreeNode(val);
                    
                    tmp.left=left;
                    tmp.right=right;
                    if(tmpLeft!=null)
                    {
                        left.left=tmpLeft;
                    }
                    if(tmpRight!=null)
                    {
                        right.right=tmpRight;
                    }
                }
                
            }
            
            curDepth++;
            if(curDepth==depth)
            {
                break;
            }
        }
        return root;
    }
}