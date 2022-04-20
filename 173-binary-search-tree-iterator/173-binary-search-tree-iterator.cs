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
public class BSTIterator {
    Stack<int> stack;
    
    public BSTIterator(TreeNode root) {
        stack = new Stack<int>();
        inOrder(root);
    }
    
    public void inOrder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inOrder(root.right);
        stack.Push(root.val);
        inOrder(root.left);
    }
    
    public int Next() {
        if(stack.Peek()!=null)
        {
            return stack.Pop();
        }
        return 0;
    }
    
    public bool HasNext() {
        if(stack.Count==0)
        {
            return false;
        }
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.Next();
 * bool param_2 = obj.HasNext();
 */