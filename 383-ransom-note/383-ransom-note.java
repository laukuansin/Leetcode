import java.util.Hashtable;
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Hashtable<Character,Integer> ht = new Hashtable<>();
        char[] ransomArr = ransomNote.toCharArray();
        for(char c:ransomArr)
        {
            ht.put(c,ht.getOrDefault(c,0)+1);
        }
        char[] magazineArr = magazine.toCharArray();
        for(char c:magazineArr)
        {
            if(ht.containsKey(c))
            {
                ht.put(c,ht.getOrDefault(c,0)-1);
            }
        }
        
      for(Map.Entry<Character,Integer> m:ht.entrySet()){  
        if(m.getValue()>0) 
            return false;
      }  
        
        return true;
    }
}