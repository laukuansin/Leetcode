class Solution {
    private Integer[] cache = new Integer[31];

    public int fib(int n) {
        if(n<2)
            return n;
        cache[0]=0;
        cache[1]=1;
        return memorize(n);
    }
    
    public int memorize(int N) {
      if (cache[N] != null) {
          return cache[N];
      }
      cache[N] = memorize(N-1) + memorize(N-2);
      return memorize(N);
    }
}