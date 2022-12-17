class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),0,nums);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> list,int idx,int[] nums)
    {
        if(nums.length==idx)
        {
            res.add(new ArrayList<>(list));
            return;
        }
        helper(res,list,idx+1,nums);
        list.add(nums[idx]);
        helper(res,list,idx+1,nums);
        list.remove(list.size()-1);
    }

}