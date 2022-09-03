class Solution {
    Set<Integer> set;
    public int[] numsSameConsecDiff(int n, int k) {
        set = new HashSet<>();
        
        for(int i=1;i<=9;i++)
            helper(n,k,i,1);
        List<Integer> list = new ArrayList<>(set);
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            arr[i]=list.get(i);
        }
        return arr;
    }
    
    public void helper(int n, int k, int ans,int count)
    {
        if(count==n)
        {
            set.add(ans);
            return;
        }
        
        int tmp = ans%10;
        for(int i=0;i<=9;i++)
        {
            if(tmp+k==i)
            {
                helper(n,k,(ans*10)+i,count+1);   
            }
            if(tmp-i>=0&&tmp-k==i)
            {
                helper(n,k,(ans*10)+i,count+1);
            }
        }
      
    }
}