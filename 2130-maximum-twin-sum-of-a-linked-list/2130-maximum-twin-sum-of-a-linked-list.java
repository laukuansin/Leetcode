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
    public int pairSum(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head.next;
        int max = Integer.MIN_VALUE;

        while(fast!=null)
        {   
            stack.add(slow.val);
            slow=slow.next;
            if(fast.next==null)
            {
                break;
            }
            fast = fast.next.next;
        }
        while(slow!=null)
        {
            int curMax = stack.pop()+slow.val;
            max = Math.max(max,curMax);
            slow=slow.next;
        }
        return max;
    }
}