class Solution {
    public int max = 0;
    public int maxLength(List<String> arr) {
        helper(arr,0,0);
        return max;
    }
    
    public void helper(List<String>arr, int index, int cur)
    {
        max = Math.max(getBitLength(cur),max);
       
        for(int i=index;i<arr.size();i++)
        {
            int newBit = getBit(arr.get(i));
            if((cur&newBit)!=0)
                continue;
            helper(arr,i+1,(cur^newBit));
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