/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer> hashMap = new HashMap<>();
        ListNode tmp = head;
        while(tmp!=null)
        {
            if(hashMap.containsKey(tmp))
            {
                return true;
            }
            else{
                hashMap.put(tmp,1);
                tmp = tmp.next;
            }
        }

        return false;
    }
}