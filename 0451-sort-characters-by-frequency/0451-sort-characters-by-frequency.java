class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        
        HashMap<Character,Integer> hm = new HashMap<>();
        PriorityQueue<Pair<Character,Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Character,Integer>>(){
             public int compare(Pair<Character,Integer> p1, Pair<Character,Integer> p2) {
                return p2.getValue().compareTo(p1.getValue());
            }
        });
        
        for(char c: charArray)
        {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
         for (Map.Entry<Character, Integer> set :hm.entrySet())
         {
            pq.add(new Pair<>(set.getKey(),set.getValue()));
         }
        
        while(!pq.isEmpty())
        {
            Pair<Character,Integer> pair = pq.remove();
            for(int i=0;i<pair.getValue();i++)
            {
                sb.append(pair.getKey());
            }
        }
        
        
        return sb.toString();
    }
}