class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0 ;
        int start=0;
        int end =1;
        char[] charArr = colors.toCharArray();
        int size = colors.length();
        while(end<size)
        {
            if(charArr[start]!=charArr[end])
            {
                start++;
                end++;
                continue;
            }
            int max=neededTime[start];
            int cum = neededTime[start];
            while(end<size&&charArr[start]==charArr[end])
            {
                max = Math.max(max, neededTime[end]);
                cum+=neededTime[end];
                start++;
                end++;
            }
            
            //if(end<size)
            ans+=(cum-max);
        }
        
        
        return ans;
    }
}