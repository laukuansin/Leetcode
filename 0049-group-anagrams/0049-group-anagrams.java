import java.util.Hashtable;


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Hashtable<String,List<String>> ht = new Hashtable<>();
        
        for(String str:strs)
        {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = new String(charArray);
            
            if(ht.containsKey(sortStr))
            {
                List<String> list = ht.get(sortStr);
                list.add(str);
                ht.put(sortStr,list);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(str);
                ht.put(sortStr,list);
            }
        }
        
        for(Map.Entry<String,List<String>> m:ht.entrySet()){ 
            res.add(m.getValue());
        }  
        return res;
    }
}