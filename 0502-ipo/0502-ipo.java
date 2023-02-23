class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Integer[] idxArr = new Integer[n];
        //Queue to store the profit
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++)
        {
            idxArr[i] = i;
        }
        Arrays.sort(idxArr, (a,b) -> capital[a]-capital[b]);

        int start = 0;
        while(k>0&&start<n)
        {
            int idx = idxArr[start];
            if(w>=capital[idx])
            {
                queue.add(profits[idx]);
                start++;
            }
            else{
                if(queue.isEmpty())
                {
                    break;
                }
                int maxProfit = queue.poll();
                w+=maxProfit;
                k--;
            }
        }
        while(k>0&&!queue.isEmpty())
        {
            w+=queue.poll();
            k--;
        }
        return w;
    }
}