class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] list = new int[nums.length];
        
        nums[queries[0][1]]+=queries[0][0];
        int initialVal = simulation(nums);
        list[0]=initialVal;
        
        for(int i=1;i<queries.length;i++)
        {
            int prev = nums[queries[i][1]];
            int cur = prev+queries[i][0];
            nums[queries[i][1]]=cur;
            //System.out.println(cur);
            if(cur%2==0&&prev%2!=0)
            {
                initialVal+=cur;
            }
            else if(cur%2!=0&&prev%2==0)
            {
                initialVal-=prev;
            }
            else if(cur%2==0&&prev%2==0){
                initialVal = initialVal-prev+cur;
            }
            
            list[i]=initialVal;
            //debug(nums);
        }
        return list;
        
    }
    
    public void debug(int[] array)
    {
         for(int i=0;i<array.length;i++)
        {
           System.out.print(array[i]+",");
        }
        System.out.println("");
    }
    
    public int simulation(int[] array)
    {
        int ans = 0;
        for(int i=0;i<array.length;i++)
        {
            if(array[i]%2==0)
            {
                ans+=array[i];
            }
        }
        return ans;
    }
}