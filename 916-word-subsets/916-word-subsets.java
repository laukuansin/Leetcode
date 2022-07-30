
// Java program to iterate through HashTable
// using entrySet method and enhance for-loop
 
// Importing required libraries
import java.util.*;
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> list = new ArrayList<>();
        int[] maxwords2Arr = new int[26];
        
        for(String str:words2)
        {
            int[] currArr = getCharacterFreq(str);
            
            for(int i=0;i<26;i++)
            {
                maxwords2Arr[i] = Math.max(currArr[i],maxwords2Arr[i]);
            }
        }
        
        
        for(String str:words1)
        {
            int[] currArr = getCharacterFreq(str);
            boolean check=true;
            for(int i=0;i<26;i++)
            {
                if(maxwords2Arr[i]>currArr[i])
                {
                    check=false;
                    break;
                }
            }
            if(check)
                list.add(str);
        }
        
        return list;
    }
    
    private int[] getCharacterFreq(String str)
    {
        int[]charArr =new int[26];
        for(char alpha:str.toCharArray())
        {
            charArr[alpha-'a']++;
        }
        return charArr;
    }
}