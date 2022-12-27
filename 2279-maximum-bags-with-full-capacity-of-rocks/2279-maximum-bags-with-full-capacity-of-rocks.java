class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int size = capacity.length;
        int res = 0;
        int startIdx = 0;
        for(int i=0;i<size;i++)
        {
            capacity[i] = capacity[i]-rocks[i];
            if(capacity[i]==0)
            {
                res++;
                startIdx++;
            }
        }
        
        Arrays.sort(capacity);
        for(int i=startIdx;i<size;i++)
        {
            if(additionalRocks-capacity[i]>=0)
            {
                res++;
                additionalRocks-=capacity[i];
            }
        }

        return res;
    }
}