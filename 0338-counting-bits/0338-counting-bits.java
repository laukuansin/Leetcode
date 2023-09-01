class Solution {
    // 1000 ->1
    // 1001 - > 2
    // 1010 ->2
    // 1011 - >3
    // 1
    public int[] countBits(int n) {
        if(n==0)
            return new int[]{0};
        if(n==1)
            return new int[]{0,1};

        int[] ans = new int[n+1];
        ans[1] = 1;
        int binary = 2;
        for(int i = 2 ; i <= n ; i ++)
        {
           if((i&(i-1))==0)
           {
               binary = i;
               ans[i] = 1;
               continue;
           }
           ans[i] = ans[i-binary]+ans[binary];
        }

        return ans;
    }
}