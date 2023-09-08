class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < numRows ; i++)
        {
            List<Integer> curList = new ArrayList<>();
            if(i==0)
            {
                curList.add(1);
            }
            else{
                for(int j = 0 ; j <= i ; j++)
                {
                    int prvVal = 0;
                    if(j!=0)
                    {
                        prvVal = ans.get(i-1).get(j-1);
                    }
                    int curVal = 0;
                    if(j!= i)
                    {
                        curVal = ans.get(i-1).get(j);
                    }
                    curList.add(prvVal+curVal);
                }
            }

            ans.add(curList);
        }
       
        return ans;
    }
}