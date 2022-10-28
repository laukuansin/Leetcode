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
            List<String> list;
            if(ht.containsKey(sortStr))
                list = ht.get(sortStr);
            else
                list = new ArrayList<>();
            
            list.add(str);
            ht.put(sortStr,list);
        }
        
        for(Map.Entry<String,List<String>> m:ht.entrySet()){ 
            res.add(m.getValue());
        }  
        return res;
    }
}