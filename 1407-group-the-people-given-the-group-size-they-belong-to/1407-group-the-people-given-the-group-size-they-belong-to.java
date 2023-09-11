class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();

        HashMap<Integer,List<Integer>> hashMap = new HashMap<>();

        for(int i = 0 ; i < groupSizes.length; i++)
        {
            List<Integer> list = hashMap.getOrDefault(groupSizes[i],new ArrayList<>());
            list.add(i);
            if(list.size()==groupSizes[i])
            {
                ans.add(new ArrayList<>(list));
                hashMap.remove(groupSizes[i]);
            }
            else{
                hashMap.put(groupSizes[i],list);
            }
                
        }

        // for (Map.Entry<Integer,List<Integer>> set :hashMap.entrySet()) 
        // {
        //     List<Integer> mapList = set.getValue();
        //     System.out.println(mapList.size());
        //     List<Integer> list = new ArrayList<>();
        //     for(int i = 0 ; i < mapList.size() ; i++)
        //     {
        //         if(i%set.getKey()==0)
        //         {
        //             ans.add(new ArrayList<>(list));
        //             list.removeAll();
        //         }
        //         list.add(mapList.get(i));
        //     }
        // }

        return ans;
    }
}