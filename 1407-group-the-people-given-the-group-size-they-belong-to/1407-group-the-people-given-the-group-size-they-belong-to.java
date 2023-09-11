class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer,List<Integer>> hashMap = new HashMap<>();

        for(int i = 0 ; i < groupSizes.length; i++)
        {
            List<Integer> list = hashMap.getOrDefault(groupSizes[i],new ArrayList<>());
            list.add(i);
            hashMap.put(groupSizes[i],list);
            if(list.size()==groupSizes[i])
            {
                ans.add(new ArrayList<>(list));
                hashMap.remove(groupSizes[i]);
            }   
        }

        return ans;
    }
}