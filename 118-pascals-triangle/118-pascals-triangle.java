class Solution {
    public List<List<Integer>> generate(int numRows){
        
        List<List<Integer>> list = new ArrayList<>();
        /*
        int[][] dp = new int[numRows][numRows];
        dp[0][0]=1;
        dp[1][0]=1;
        dp[1][1]=1;
        List<Integer> list1 = Arrays.asList(dp[0]);
        list.add(list1);
        if(numRows<2)
        {
            return list;
        }
        List<Integer> list2 = Arrays.asList(dp[1]);
        list.add(list2);
        if(numRows<3)
        {
            return list;
        }
        
        for(int i=3;i<=numRows;i++)
        {
            for(int j=1;j<i-1;j++)
            {
                dp[i-1][j]=dp[i-2][j]+dp[i-2][j-1];
            }
            
            List<Integer> temp = Arrays.asList(dp[i-1]);
             list.add(temp);
        }
        return list;
        */
        for(int i=0;i<numRows;i++)
        {
            List<Integer> innerList = new ArrayList<>();
            for(int j=0;j<=i;j++)
            {
                if(j==0||j==i)
                {
                    innerList.add(1);
                    continue;
                }
                int num = list.get(i-1).get(j)+list.get(i-1).get(j-1);
                innerList.add(num);
            }
            list.add(innerList);
        }
        
        return list;
    }
}