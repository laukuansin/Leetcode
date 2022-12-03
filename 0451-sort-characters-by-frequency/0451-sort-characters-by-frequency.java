
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        
        HashMap<Character,Integer> hm = new HashMap<>();
        
        for(char c: charArray)
        {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        List<Entry<Character, Integer>> nlist = new ArrayList<>(hm.entrySet());
        nlist.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        for(Entry<Character,Integer> entry:nlist)           
       {
            for(int i=0;i<entry.getValue();i++)
            {
                sb.append(entry.getKey());
            }
       }
        
        
        return sb.toString();
    }
}