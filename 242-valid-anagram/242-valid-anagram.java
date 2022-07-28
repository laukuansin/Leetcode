import java.util.*;
import java.util.Map.Entry;
import java.util.Set;

import java.util.Enumeration;
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Hashtable<Character,Integer> hashTable = new Hashtable<>();
        for(char c:s.toCharArray())
        {
            hashTable.put(c,hashTable.getOrDefault(c,0)+1);
        }
        for(char c:t.toCharArray())
        {
            hashTable.put(c,hashTable.getOrDefault(c,0)-1);
        }
        Set<Entry<Character,Integer>> entrySet = hashTable.entrySet();
        for(Entry<Character,Integer> set:entrySet){  
            if(set.getValue()!=0)
            {
                return false;
            }
        }  
        return true;
    }
}