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
import java.util.Hashtable;
class Solution {
    Hashtable<Integer,Integer> ht = new Hashtable<>();
    public boolean findTarget(TreeNode root, int k) {
        /* BFS
        Hashtable<Integer,Integer> ht = new Hashtable<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(queue.size()!=0)
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode tmp = queue.poll();
                if(tmp.left!=null)
                {
                    queue.add(tmp.left);
                }
                
                if(tmp.right!=null)
                {
                    queue.add(tmp.right);
                }
                
                if(ht.containsKey(k-tmp.val))
                {
                    return true;
                }
                ht.put(tmp.val,1);
            }
        }
        return false;
        */
        if(root==null)
        {
            return false;
        }
        if(ht.containsKey(k-root.val))
            return true;   
        else
            ht.put(root.val,1);
        return findTarget(root.left,k)||findTarget(root.right,k);
        
    }
}