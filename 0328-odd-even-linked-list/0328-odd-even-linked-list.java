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
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        
        ListNode firstHalf = head;
        ListNode secondHalf = new ListNode(0);
        ListNode curSecondHalf = secondHalf;
        
        while(firstHalf!=null&&firstHalf.next!=null)
        {
            ListNode next = firstHalf.next;
            curSecondHalf.next = next;
            curSecondHalf=curSecondHalf.next;
            if(firstHalf.next.next==null)
            {
                break;
            }
            
            firstHalf.next=next.next;
            next.next=null;
            firstHalf = firstHalf.next;
        }
        //System.out.println(firstHalf.val);
        firstHalf.next=secondHalf.next;
        
        return head;
    }
}