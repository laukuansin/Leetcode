class Solution {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        while(!(a==0&&b==0&&c==0))
        {
            int aCurrentBit = a&1;
            int bCurrentBit = b&1;
            int cCurrentBit = c&1;
            int aOrb = aCurrentBit|bCurrentBit;
            if(aOrb!=cCurrentBit)
            {
                if(aCurrentBit==1&&bCurrentBit==1)
                {
                    ans+=2;
                }
                else{
                    ans+=1;
                }
            }
            a>>=1;
            b>>=1;
            c>>=1;
        }
        
        return ans;
    }
}