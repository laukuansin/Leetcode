class Solution {
    // 1000 ->1
    // 1001 - > 2
    // 1010 ->2
    // 1011 - >3
    // 1
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 0 ; i <= n ; i ++)
        {
            int count = 0;
            int tmp = i;
            while(tmp!=0)
            {
                if(tmp%2==1)
                {
                    count++;
                }
                tmp>>=1;
            }
            ans[i] = count;
        }

        return ans;
    }
}