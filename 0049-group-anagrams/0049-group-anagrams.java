import java.util.Hashtable;


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Hashtable<String,List<String>> ht = new Hashtable<>();
        
        for(String str:strs)
        {
            char[] charArray = new char[26];
            for(char c: str.toCharArray())
            {
                charArray[c-'a']++;
            }
            List<String> list;
            if(ht.containsKey(new String(charArray)))
                list = ht.get(new String(charArray));
            else
                list = new ArrayList<>();
            
            list.add(str);
            ht.put(new String(charArray),list);
        }
        
        for(Map.Entry<String,List<String>> m:ht.entrySet()){ 
            res.add(m.getValue());
        }  
        return res;
    }
}