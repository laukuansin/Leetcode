class Solution {
    int MOD = 1000000007;
    public int concatenatedBinary(int n) {
       
        long ans =0;
        for(int i=1;i<=n;i++)
        {
            ans<<=1;
            String str = Integer.toBinaryString(i);
            char[] c=str.toCharArray();
            for(int j=0;j<str.length();j++)
            {

                if(c[j]=='1')
                {
                    ans|=1;
                }
                ans<<=1;
            }
            ans>>=1;
            ans%=MOD;
        }
        return (int)ans%MOD;
    }
}