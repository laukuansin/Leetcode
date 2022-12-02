class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length())
        {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        char[] word1Arr = word1.toCharArray();
        char[] word2Arr = word2.toCharArray();
        TreeMap<Integer,Integer> treeMap1 = new TreeMap<>();
        TreeMap<Integer,Integer> treeMap2 = new TreeMap<>();
        for(int i=0;i<word2.length();i++)
        {
            count1[word1Arr[i]-'a']++;
            count2[word2Arr[i]-'a']++;
        }

        for(int i=0;i<26;i++)
        {
            if(count1[i]==0&&count2[i]==0)
            {
                continue;
            }
            else if(count1[i]>0&&count2[i]>0)
            {
                treeMap1.put(count1[i],treeMap1.getOrDefault(count1[i],0)+1);
                treeMap2.put(count2[i],treeMap2.getOrDefault(count2[i],0)+1);
            }
            else{
                return false;
            }
        }
         for (Map.Entry<Integer, Integer> e :treeMap1.entrySet())
         {
            if(treeMap2.containsKey(e.getKey()))
            {
                if(treeMap2.get(e.getKey())!=e.getValue())
                    return false;
            }
            else{
                return false;
            }
         }
    
        return true;
    }
}