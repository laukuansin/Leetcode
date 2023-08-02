class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans,new ArrayList<>(),new boolean[nums.length],nums);
        return ans;
    }

    public void helper(List<List<Integer>> ans,List<Integer> curList,boolean[] visited,int[] nums)
    {
        if(curList.size()==nums.length)
        {
            ans.add(new ArrayList<>(curList));
            return;
        }

        for(int i = 0 ; i < nums.length ; i ++)
        {
            if(visited[i])
                continue;

            visited[i] = true;
            curList.add(nums[i]);
            helper(ans,curList,visited,nums);
            curList.remove(curList.size()-1);
            visited[i] = false;
        }
    }
}