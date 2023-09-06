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
    public ListNode[] splitListToParts(ListNode head, int k) {
        if(head==null)
            return new ListNode[k];
        if(k==1)
            return new ListNode[]{head};

        ListNode[] ans = new ListNode[k];
        int totalSize = getSize(head);
        int sizePerElement = totalSize/k;
        int extraAddOnPerElement = totalSize%k;

        ListNode cur = head;
        ListNode prv = null;

        for(int i = 0 ; i < k ; i++)
        {
            int count = sizePerElement;
            ListNode curHead = cur;
            while(count>0&&cur!=null)
            {
                prv = cur;
                cur = cur.next;
                count--;
            }
            if(extraAddOnPerElement>0&&cur!=null)
            {
                prv = cur;
                cur = cur.next;
                extraAddOnPerElement--;
            }
            if(cur!=null)
            {
                prv.next = null;
            }
            ans[i] = curHead;
        }

        return ans;
    }

    public int getSize(ListNode head)
    {
        int totalSize = 0;
        ListNode cur = head;
        while(cur!=null)
        {
            totalSize++;
            cur = cur.next;
        }
        return totalSize;
    }
}