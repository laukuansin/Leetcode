class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(),0,nums);
        return ans;
    }

    public void helper(List<List<Integer>> ans,List<Integer> curList,int index,int[] nums)
    {
        if(curList.size()==nums.length)
        {
            ans.add(new ArrayList<>(curList));
            return;
        }

        for(int i = 0 ; i < nums.length ; i ++)
        {
            if(curList.contains(nums[i]))
                continue;
            curList.add(nums[i]);
            helper(ans,curList,i+1,nums);
            curList.remove(curList.size()-1);
        }
    }
}