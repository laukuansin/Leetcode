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

 /*DFS method
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //case 1: When both node are null, mean equal to same
        if(p==null&&q==null)
            return true;
        else if(p!=null&&q!=null)//case 2: when both node are not null, then mean got 2 probarbility such as both are same value or both are not same value. Then we will recursive to left and right
            return p.val==q.val&&isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        else//case 3: either one node is null
            return false;
    }
}*/

//BFS method
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null)
            return true;

        Queue<TreeNode> queueP = new LinkedList<TreeNode>();
        Queue<TreeNode> queueQ = new LinkedList<TreeNode>();

        queueP.add(p);
        queueQ.add(q);

        while(!queueP.isEmpty()&&!queueQ.isEmpty())
        {
            int sizeP = queueP.size();
            int sizeQ = queueQ.size();

            for(int i=0;i<sizeP||i<sizeQ;i++)
            {
                TreeNode currPNode = queueP.poll();
                TreeNode currQNode = queueQ.poll();
                if(currPNode!=null&&currQNode!=null)
                {
                    if(currPNode.val!=currQNode.val)
                    {
                        return false;
                    }
                    if(currPNode.left!=null&&currQNode.left!=null)
                    {
                        queueP.add(currPNode.left);
                        queueQ.add(currQNode.left);
                    }
                    else 
                    {
                        if(!(currPNode.left==null&&currQNode.left==null))
                        {
                            return false;
                        }
                    }

                    if(currPNode.right!=null&&currQNode.right!=null)
                    {
                        queueP.add(currPNode.right);
                        queueQ.add(currQNode.right);
                    }
                    else
                    {
                         if(!(currPNode.right==null&&currQNode.right==null))
                         {
                            return false;
                         }
                    }
                }
                else{
                    if(!(currPNode==null&&currQNode==null))
                    {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}