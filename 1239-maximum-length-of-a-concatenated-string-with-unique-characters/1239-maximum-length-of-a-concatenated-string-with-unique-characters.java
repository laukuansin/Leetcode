class Solution {
    public int max = 0;
    public int maxLength(List<String> arr) {
        for(int i=0;i<arr.size();i++)
        {
            helper(arr,i,0);
        }
        return max;
    }
    
    public void helper(List<String>arr, int index, int res)
    {
        int cur = getBit(arr.get(index));
        
        if((cur&res)==0)
        {
            res^=cur;
        }
        else{
            res = cur;
        }
        max = Math.max(getBitLength(res),max);
        
        for(int i=index+1;i<arr.size();i++)
        {
            helper(arr,i,res);
        }
    }
    
    public int getBit(String str)
    {
        char[] charArr = str.toCharArray();
        int bit = 0;
        for(char c:charArr)
        {
            int num = c-'a';
            
            if((bit&1<<num)!=0)
                return 0;
            bit^=1<<num;
        }
        return bit;
    }
    
    public int getBitLength(int bit)
    {
        int length = 0;
        while(bit!=0)
        {
            int cond = bit&1;
            if(cond==1)
                length++;
            bit>>=1;
        }
        return length;
    }
}