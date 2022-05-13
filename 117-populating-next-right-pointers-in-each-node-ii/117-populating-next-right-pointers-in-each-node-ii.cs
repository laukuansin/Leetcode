/*
// Definition for a Node.
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

public class Solution {
    public Node Connect(Node root) {
        if(root==null)
        {
            return root;
        }
        Queue<Node> queue = new Queue<Node>();
        queue.Enqueue(root);
        
        while(queue.Count!=0)
        {
            Node prev = null;
             int size = queue.Count;   
            for(int i =0;i<size;i++)
            {
                Node tmp=queue.Dequeue();
                if(prev!=null)
                {
                    prev.next=tmp;
                }
                
                prev=tmp;
                if(tmp.left!=null)
                {
                    queue.Enqueue(tmp.left);
                }
                if(tmp.right!=null)
                {
                    queue.Enqueue(tmp.right);
                }
                
            }
        }
        
        return root;
    }
}