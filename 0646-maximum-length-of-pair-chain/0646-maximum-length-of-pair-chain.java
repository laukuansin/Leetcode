class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,new Comparator<int[]>()
        {
            public int compare(int[] a,int[] b)
            {
                return a[1]-b[1];
            }
        });
    
        return helper(pairs,0,-1001,new Integer[pairs.length]);
    }

    public int helper(int[][] pairs,int idx,int previousVal,Integer[] memo)
    {
        if(idx>=pairs.length)
        {
            return 0;
        }

        if(memo[idx]!=null)
            return memo[idx];

        int max = Integer.MIN_VALUE;
        if(pairs[idx][0]>previousVal)
        {
            max = 1+helper(pairs,idx+1,pairs[idx][1],memo);
        }
        max = Math.max(max, helper(pairs,idx+1,previousVal,memo));


        return memo[idx]=max;
    }
}