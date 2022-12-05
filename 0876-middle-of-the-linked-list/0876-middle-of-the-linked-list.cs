/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode MiddleNode(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        
        while(fastNode!=null&&fastNode.next!=null)
        {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        
        return slowNode;
    }
}