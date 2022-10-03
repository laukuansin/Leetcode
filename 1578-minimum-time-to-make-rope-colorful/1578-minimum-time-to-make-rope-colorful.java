class Solution {
    public int minCost(String colors, int[] neededTime) {
        int ans = 0 ;
        int start=0;
        int end =0;
        char[] charArr = colors.toCharArray();
        int size = colors.length();
        int max=Integer.MIN_VALUE;
        int cum =0;
        while(end<size)
        {
            if(charArr[start]!=charArr[end])
            {
                start=end;
                
                ans+=(cum-max);
                max=neededTime[end];
                cum=0;//neededTime[end];
                continue;
            }
            max=Math.max(max,neededTime[end]);
            cum+=neededTime[end];
            end++;
            /*
            while(end<size&&charArr[start]==charArr[end])
            {
                max = Math.max(max, neededTime[end]);
                cum+=neededTime[end];
                start++;
                end++;
            }
            ans+=(cum-max);*/
            
        }
        if(end>=size)
        {
            ans+=(cum-max);
        }
        
        return ans;
    }
}