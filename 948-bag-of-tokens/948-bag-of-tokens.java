class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int maxScore = 0;
        Arrays.sort(tokens);
       
        int start=0;
        int ans=0;
        int end=tokens.length-1;
        while(start<=end)
        {
            
            if(tokens[start]<=power)
            {
                power-=tokens[start];
                maxScore++;
                start++;
                ans=Math.max(ans,maxScore);
            }
            else if(tokens[start]>power&&maxScore>0)
            {
                 
                power+=tokens[end];
                maxScore--;
                end--;
            }
            else
            {
                break;
            }
           
        }
        
        return ans;
    }
}