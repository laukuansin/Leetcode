class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        List<Pair<Integer,Integer>> list = new ArrayList<>();
        
        for(int i=0;i<plantTime.length;i++)
        {
            list.add(new Pair<Integer,Integer>(plantTime[i],growTime[i]));
        }
        Collections.sort(list, new Comparator<Pair<Integer,Integer>>() {
          public int compare(Pair<Integer,Integer> p1, Pair<Integer,Integer> p2) {
            if (p1.getValue() > p2.getValue()) return -1;
            if (p1.getValue() < p2.getValue()) return 1;
            return 0;
          }});
        int cur = 0;
        int max = 0;
        
        for(Pair<Integer,Integer> pair:list)
        {
            //key: grow time
            //value: plant time
            cur+=pair.getKey();
            max = Math.max(cur+pair.getValue(),max);
            //System.out.println("V:"+entry.getValue()+",key:"+entry.getKey());
        }
        
        return max;
        
    }
}