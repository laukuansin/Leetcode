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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null||head.next==null)
            return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode slow = prev.next;
        ListNode fast = prev.next;
        
        while(fast!=null&&fast.next!=null)
        {
            prev= prev.next;
            slow = slow.next;
            if(fast.next.next==null)
                break;
            fast = fast.next.next;
        }
        if(slow.next==null)
        {
            prev.next = null;   
        }
        else
        {
            prev.next=slow.next;
            slow.next=null;
        }
        return head;   
    }
}