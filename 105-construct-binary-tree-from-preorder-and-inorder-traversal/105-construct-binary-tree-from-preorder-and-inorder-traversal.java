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
    int preOrderIndex = 0;
    HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++)
        {
            hashMap.put(inorder[i],i);
        }
        return arrToTree(preorder,0,preorder.length-1);
    }
    
    public TreeNode arrToTree(int[] preorder,int left, int right)
    {
        if(left>right)   
        {
            return null;
        }
        
        int num = preorder[preOrderIndex++];
        TreeNode node = new TreeNode(num);
        
        node.left = arrToTree(preorder,left,hashMap.get(num)-1);
        node.right=arrToTree(preorder,hashMap.get(num)+1,right);
        return node;
    }
}