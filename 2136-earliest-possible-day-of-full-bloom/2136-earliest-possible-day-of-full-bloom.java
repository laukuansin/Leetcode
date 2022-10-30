class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        //List<Pair<Integer,Integer>> list = new ArrayList<>();
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
        
    }
}