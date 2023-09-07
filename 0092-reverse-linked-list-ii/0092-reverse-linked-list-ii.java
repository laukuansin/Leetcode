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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right)
            return head;
        
        ListNode oldTail = head;
        ListNode newTail = null;
        int count = right-1;
        while(count>=0&&oldTail!=null)
        {
            newTail = oldTail;
            oldTail = oldTail.next;
            count--;
        }

        newTail.next = null;

        ListNode oldHead = null;
        ListNode newHead = head;
        count = left-1;
        while(count>0&&newHead!=null)
        {
            oldHead = newHead;
            newHead = newHead.next;
            count--;
        }
        if(oldHead!=null)
            oldHead.next = null;

        ListNode curNode = newHead;
        ListNode prvNode = null;

        while(curNode!=null)
        {
            if(curNode.next==null)
            {
                curNode.next = prvNode;
                break;
            }
            ListNode nextNode = curNode.next;
            curNode.next = prvNode;
            prvNode = curNode;
            curNode = nextNode;
        }
        if(oldHead!=null)
        {
            oldHead.next = newTail;
            newHead.next = oldTail;
            return head;
        }
        else{
            newHead.next = oldTail;
            return newTail;
        }
           
    }
}