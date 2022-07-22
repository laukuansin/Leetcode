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
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)
            return head;
        
        ListNode dummy = new ListNode(0);
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftCur=left;
        ListNode rightCur=right;
        while(head!=null)
        {
            if(head.val<x)
            {
                leftCur.next=new ListNode(head.val);
                leftCur=leftCur.next;
            }
            else{
                rightCur.next=new ListNode(head.val);
                rightCur=rightCur.next;
            }
            head=head.next;
        }
        if(left.next==null)
        {
            dummy.next=right.next;
        }
        else if(left.next==null)
        {
            dummy.next=left.next;
        }
        else{
            dummy.next=left.next;
            leftCur.next=right.next;
        }
        
        return dummy.next;
    }
}