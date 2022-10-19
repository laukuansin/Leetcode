import java.util.Hashtable;
class StrFreq{
    private String str;
    private int freq;
    
    StrFreq(String str,int freq)
    {
        this.str=str;
        this.freq=freq;
    }
    
    public String getStr()
    {
        return this.str;
    }
    
    public int getFreq()
    {
        return this.freq;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<String>();
        Hashtable<String,Integer> ht = new Hashtable<>();
        for(String word:words)
        {
            ht.put(word,ht.getOrDefault(word,0)+1);
        }
        PriorityQueue<StrFreq> queue=new PriorityQueue<StrFreq>(ht.size(), new Comparator<StrFreq>() {
            public int compare(StrFreq c1, StrFreq c2) {
                int com = c2.getFreq()-c1.getFreq();
                if(com==0)
                {
                    com = c1.getStr().compareTo(c2.getStr());
                }
                
                return com;
                
            }
        });
        for(Map.Entry<String, Integer> entry: ht.entrySet()) {
            StrFreq strFreq = new StrFreq(entry.getKey(),entry.getValue());
            queue.add(strFreq);
		}
        
        
        
        while(k>0)
        {
            StrFreq strFreq = queue.poll();
            res.add(strFreq.getStr());
            k--;
        }
        return res;
    }
}