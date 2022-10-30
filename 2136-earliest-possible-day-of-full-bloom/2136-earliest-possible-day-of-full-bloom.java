class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        //List<Pair<Integer,Integer>> list = new ArrayList<>();
        /*
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<plantTime.length;i++)
        {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
          public int compare(Integer i1, Integer i2) {
            if (growTime[i1] > growTime[i2]) return -1;
            if (growTime[i1] < growTime[i2]) return 1;
            return 0;
          }});
        int cur = 0;
        int max = 0;
        
        for(int idx:list)
        {
            //key: grow time
            //value: plant time
            cur+=plantTime[idx];
            max = Math.max(cur+growTime[idx],max);
            //System.out.println("V:"+entry.getValue()+",key:"+entry.getKey());
        }
        
        return max;
        */
         int n = growTime.length;
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            indices.add(i);
        }
        Collections.sort(indices, Comparator.comparingInt(i -> -growTime[i]));
        int result = 0;
        for (int i = 0, curPlantTime = 0; i < n; ++i) {
            int idx = indices.get(i);
            int time = curPlantTime + plantTime[idx] + growTime[idx];
            result = Math.max(result, time);
            curPlantTime += plantTime[idx];
        }
        return result;
    }
}