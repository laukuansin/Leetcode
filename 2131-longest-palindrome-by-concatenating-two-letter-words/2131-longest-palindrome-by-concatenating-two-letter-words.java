import java.util.Hashtable;
class Solution {
    public int longestPalindrome(String[] words) {
        Hashtable<String,Integer> ht = new Hashtable<>();
        int maxlen = 0;
        int pair = 0;
        for(String word:words)
        {
            char[] charArr = word.toCharArray();
            String rev = charArr[1]+""+charArr[0];
            
            if(ht.containsKey(rev)&&ht.get(rev)>0)
            {
                ht.put(rev,ht.getOrDefault(rev,0)-1);
                maxlen+=4;
                if(word.equals(rev))
                    pair--;
                continue;
            }
            
            if(word.equals(rev))
                pair++;
            ht.put(word,ht.getOrDefault(word,0)+1);
            
        
        }
            if(pair>0)
            {
                maxlen+=2;
            }
        return maxlen;
    }
}