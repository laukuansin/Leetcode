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
        ListNode lowNode = new ListNode(0);
        ListNode highNode = new ListNode(0);
        ListNode curLowNode = lowNode;
        ListNode curHighNode = highNode;

        ListNode curNode = head;

        while(curNode!=null)
        {
            if(curNode.val<x)
            {
                curLowNode.next = new ListNode(curNode.val);
                curLowNode = curLowNode.next;
            }
            else{
                curHighNode.next = new ListNode(curNode.val);
                curHighNode = curHighNode.next;
            }

            curNode = curNode.next;
        }

        curLowNode.next = highNode.next;
        return lowNode.next;
    }
}