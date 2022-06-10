  
import java.io.*;
import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Hashtable<Character,Integer> hashtable = new Hashtable<Character,Integer>();
        int max = 0;
        
        for(int i=0,j=0;j<s.length();j++)
        {
            char c = s.charAt(j);
            if(hashtable.containsKey(c))
            {
                i=Math.max(hashtable.get(c)+1,i);
            }
            max=Math.max(max,j-i+1);
            hashtable.put(c,j);
        }
        
        return max;
    }
}