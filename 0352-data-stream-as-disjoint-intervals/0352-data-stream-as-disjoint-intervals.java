class SummaryRanges {
    TreeMap<Integer,Integer> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int value) {
        if(map.isEmpty())
        {
            map.put(value,value);
            return;
        }
        int[] cur = new int[]{value,value};
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> m = iterator.next();
            if(cur[0]==cur[1])
            {
                if(cur[0]>=m.getKey()&&cur[0]<=m.getValue())
                {
                    return;
                }
                if(cur[0]==m.getKey()-1)
                {
                    int tempVal = m.getValue();
                    iterator.remove();
                    cur[1] = tempVal;
                    break;
                }
                if(cur[1]==m.getValue()+1)
                {
                    int tempKey = m.getKey();
                    iterator.remove();
                    cur[0] = tempKey;
                }
            }   
            else{
                if(cur[1]==m.getKey()-1)
                {
                    int tempValue = m.getValue();
                    iterator.remove();
                    cur[1] = tempValue;
                }
                else{
                    if(cur[0]!=cur[1])
                    {
                        break;
                    }
                }
            } 
        }
        map.put(cur[0],cur[1]);
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2]; 
        int count=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){    
            res[count++] = new int[]{m.getKey(),m.getValue()};
        } 
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */