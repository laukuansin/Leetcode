import java.util.*;
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for(String str:words)
        {
            if(str.length()!=pattern.length())
                continue;
            
            Hashtable<Character,Character> hashtable = new Hashtable<>();
            boolean check = true;
            for(int i=0;i<pattern.length();i++)
            {
                
                if(hashtable.containsKey(pattern.charAt(i)))
                {
                    if(hashtable.get(pattern.charAt(i))!=str.charAt(i))
                    {
                        check=false;
                        break;
                    }
                }
                else{
                    if(!hashtable.containsValue(str.charAt(i)))
                    {
                        
                        hashtable.put(pattern.charAt(i),str.charAt(i));
                       
                    }
                    else{
                         check=false;
                        break;
                    }
                }
            }
            if(check)
            {
                list.add(str);
            }
        }
        return list;
    }
}