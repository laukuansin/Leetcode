/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    /*
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> res = new ArrayList<>();
        ListNode tmp = head;
        while(tmp!=null)
        {
            res.add(tmp.val);
            tmp = tmp.next;
        }
        return constructBST(0,res.size()-1,res);
    }

    public TreeNode constructBST(int start, int end,List<Integer> list)
    {
        if(start<=end)
        {
            int mid = (end+start)/2;
            TreeNode node = new TreeNode(list.get(mid));
            node.left = constructBST(start,mid-1,list);
            node.right = constructBST(mid+1,end,list);
            return node;
        }
        else{
            return null;
        }
    }*/
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
        {
            return null;
        }
        if(head.next==null)
        {
            return new TreeNode(head.val);
        }
        ListNode slowNode = head;
        ListNode fastNode = head.next.next;
        while(fastNode!=null&&fastNode.next!=null)
        {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        TreeNode node = new TreeNode(slowNode.next.val);
        ListNode rightHlaf = slowNode.next.next;
        slowNode.next = null;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(rightHlaf);
        return node;
    }
}