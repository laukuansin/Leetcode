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
    public ListNode mergeKLists(ListNode[] lists) {
        //ListNode
        ListNode head = new ListNode();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode list:lists)
        {
            ListNode tmp = list;
            while(tmp!=null)
            {
                pq.add(tmp.val);
                tmp = tmp.next;
            }
        }
        ListNode tmp = head;
        while(!pq.isEmpty())
        {
            int pollVal = pq.poll();
            tmp.next = new ListNode(pollVal);
            tmp = tmp.next;
        }
        return head.next;
    }

    public void mergeSort()
    {

    }
}