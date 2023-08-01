class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(),1,n,k);
        return ans;
    }
    
    public void helper(List<List<Integer>> ans,List<Integer> curList,int num,int n,int k)
    {
        if(curList.size()==k)
        {
            ans.add(new ArrayList<>(curList));
            return;
        }

        for(int i = num ; i <= n ; i++)
        {
            curList.add(i);
            helper(ans,curList,i+1,n,k);
            curList.remove(curList.size()-1);
        }
    }

    /*
    *
    *   1,2,3,4
    *
    */
}