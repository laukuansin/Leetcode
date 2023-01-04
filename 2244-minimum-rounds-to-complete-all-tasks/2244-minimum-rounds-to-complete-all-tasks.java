class Solution {
    public int minimumRounds(int[] tasks) {
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<tasks.length;i++)
        {
            hm.put(tasks[i],hm.getOrDefault(tasks[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> m : hm.entrySet()){
            if(m.getValue()==1)    
                return -1;
            if(m.getValue()%3==0)
                ans+= m.getValue()/3;
            else
                ans+= (m.getValue()/3)+1;
        }  
        return ans;
    }
}