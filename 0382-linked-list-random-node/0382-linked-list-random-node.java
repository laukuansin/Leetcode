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
    ListNode head;
    List<Integer> shuffleList;
    int capacity;
    public Solution(ListNode head) {
        this.head = head;
        capacity = 0;
        ListNode tmp = head;
        while(tmp!=null)
        {
            capacity++;
            tmp = tmp.next;
        }
       // randomShuffle();
    }

    private void randomShuffle()
    {
        Random r = new Random();
        for(int i=shuffleList.size()-1;i>0;i--)
        {
            int j = r.nextInt(i+1);
            int temp = shuffleList.get(i);
            shuffleList.set(i,shuffleList.get(j));
            shuffleList.set(j,temp);
        }
    }
    
    public int getRandom() {
        Random r = new Random();
        int randomNum = r.nextInt(capacity);
        ListNode tmp = head;
        while(randomNum>0)
        {
            tmp = tmp.next;
            randomNum--;
        }
        return tmp.val;
        /*
        if(curIdx==shuffleList.size())
        {
            randomShuffle();
        }
        return shuffleList.get(curIdx++);*/
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */