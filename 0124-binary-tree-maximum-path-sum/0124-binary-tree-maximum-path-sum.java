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
    int max= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    public int helper(TreeNode root)
    {
        if(root==null)
            return 0;

        int left = helper(root.left);
        int right = helper(root.right);
        int curLeftMax = left+root.val;//The maximum sum of the left path
        int curRightMax = right+root.val;//The maximum sum of the right path
        int curMidMax = left+right+root.val;//The maximum sum of the left path and right
        int curMax = Math.max(curLeftMax,Math.max(curRightMax,Math.max(curMidMax, root.val)));//find the maxium sum among these 4 path
        //example 
        //    20
        //   /  \
        // 15    7
        //
        //4 possible
        //1. 20 is maximum
        //2. 15+20 is maximum
        //3. 20+7 is maximum
        //4. 15+20+7 is maximum
        max=Math.max(curMax,max);

        return Math.max(curLeftMax,Math.max(curRightMax, root.val));
        //at here did not return curMidMax is because it is invalid path
    }
}