class Solution {
    public String longestPalindrome(String s) {
        int length=s.length();
        if(length<2)
        {
            return s;
        }
        int start = 0;
        int maxlen=1;
        for(int i=0;i<length;i++)
        {
            int odd=expandedCenter(s.toCharArray(),i,i);
            int even=expandedCenter(s.toCharArray(),i,i+1);
            int max=Math.max(odd,even);
            
            if(maxlen<max)
            {
                maxlen=max;
                start=i-(max-1)/2;
            }
            
        }
        return s.substring(start,start+maxlen);
    }
    
    public int expandedCenter(char[] str,int i,int j)
    {
        int len=str.length;
        while(i>=0&&j<len)
        {
            if(str[i]==str[j])
            {
                i--;
                j++;
            }
            else{
                break;
            }
        }
        return j-i-1;
    }
    
   
}