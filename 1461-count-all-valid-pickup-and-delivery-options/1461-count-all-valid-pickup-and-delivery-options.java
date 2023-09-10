class Solution {
    int MOD = 1000000007;
    public int countOrders(int n) {
        long result = 1;
        int x = 1;
        int totalSum = 1;

        for(int i = 1 ; i < n ; i++)
        {
            totalSum += (x+1)+(x+2);
            result = (result*totalSum)%MOD;
            x+=2;
        }
        return (int)(result%MOD);
    }
}