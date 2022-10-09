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
    public boolean findTarget(TreeNode root, int k) {
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
    }
}