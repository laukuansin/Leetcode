class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursive(res,new ArrayList<>(),0,nums,new HashSet<>());
        return res;
    }

    public void recursive(List<List<Integer>> res,List<Integer> list, int idx, int[] nums,Set<List<Integer>> set)
    {
        if(list.size()>=2)
        {
            if(!set.contains(new ArrayList<>(list)))
            {
                set.add(new ArrayList<>(list));
                res.add(new ArrayList<>(list));
            }
        }

        for(int i=idx;i<nums.length;i++)
        {
            boolean check = false;//to keep track on removing those num that added after backtracking
            if(list.size()>0)
            {
                if(nums[i]>=list.get(list.size()-1))
                {
                    list.add(nums[i]);
                    check = true;
                }
            }
            else{
                check = true;
                list.add(nums[i]);
            }

            recursive(res,list,i+1,nums,set);
            if(list.size()>0&&check)
                list.remove(list.size()-1);
        }
    }
}