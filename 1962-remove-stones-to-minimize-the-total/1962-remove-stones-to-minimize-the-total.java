class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int res = 0;
        for(int i=0;i<piles.length;i++)
        {
            pq.add(piles[i]);
            res+=piles[i];
        }
        int count = 0;
        while(count<k)
        {
            int curMax = pq.poll();
            int curMaxDeduct = (int)Math.floor((double)curMax/2);
            res-=curMaxDeduct;
            pq.add(curMax-curMaxDeduct);
            count++;
        }
        return res;
    }
}