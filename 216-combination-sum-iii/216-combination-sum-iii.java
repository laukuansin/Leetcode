class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,k,n,new ArrayList<Integer>(),1);
        return list;
    }
    
    public void helper(List<List<Integer>> list,int k, int target,List<Integer> curList,int idx)
    {
        if(k==curList.size()&&target==0)
        {
            list.add(new ArrayList<Integer>(curList));
            return;
        }
        for(int i=idx;i<=9;i++)
        {
            if(curList.contains(i))
            {
                continue;
            }
            curList.add(i);
            helper(list,k,target-i,curList,i+1);
            curList.remove(curList.size()-1);
        }
    }
}