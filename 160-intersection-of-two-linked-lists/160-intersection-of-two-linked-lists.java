/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;
        
        while(curA!=curB)
        {
            curA=curA==null?headA:curA.next;
            curB=curB==null?headB:curB.next;
        }
        return curB;
    }
}