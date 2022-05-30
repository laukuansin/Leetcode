class Solution {
    public int divide(int dividend, int divisor) {
         if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        boolean positive = (dividend>0&&divisor>0)||(dividend<0&&divisor<0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result=0;
        int shift =31;
        while(a>=b)
        {
            while(a<b<<shift)
            {
                shift--;
            }
            a-=b<<shift;
            result+=1<<shift;
        }
        
        return positive?result:-result;
    }
}