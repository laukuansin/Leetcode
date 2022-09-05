/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> list = new ArrayList<>();
        if(root==null)
            return list;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        while(queue.size()!=0)
        {
            int size = queue.size();
            List<Integer> tmpList = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                Node tmp = queue.poll();
                tmpList.add(tmp.val);
                if(tmp.children!=null)
                {
                    for(Node child:tmp.children)
                    {
                        queue.add(child);
                    }
                }
            }
            list.add(tmpList);
        }
        
        
        return list;
    }
}