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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return null;
        
        ListNode cur = head;
        int count=0;
        while(cur!=null)
        {
            cur=cur.next;
            count++;
        }
        count-=n;
        
        ListNode prev =null;
        ListNode current = head;
        ListNode next = current.next;
        int track =1;
        while(track<=count)
        {
            prev=current;
            current = prev.next;
            if(next != null)
                next=next.next;
            
            track++;
        }
        if(prev==null)
        {
            head=head.next;
        }
        else if(next==null)
        {
            prev.next=null;
        }
        else{
            prev.next=current.next;
        }
        return head;
    }
}