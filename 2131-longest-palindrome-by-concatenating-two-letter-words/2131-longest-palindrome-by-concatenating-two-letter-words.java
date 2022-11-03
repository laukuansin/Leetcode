import java.util.Hashtable;
class Solution {
    public int longestPalindrome(String[] words) {
        Hashtable<String,Integer> ht = new Hashtable<>();
        int palindromeMax = 0;
        int nonPalindromeMax = 0;
        String strPalindromeMax = "";
        for(String word:words)
        {
            ht.put(word,ht.getOrDefault(word,0)+1);
        }
        for(Map.Entry<String,Integer> m:ht.entrySet())
        {
            char[] charArr = m.getKey().toCharArray();
            if(charArr[0]==charArr[1])
            {
                if(ht.get(m.getKey())%2!=0&&ht.get(m.getKey())>ht.getOrDefault(strPalindromeMax,0))
                {
                    strPalindromeMax = m.getKey();
                }
            }
        }
        for(Map.Entry<String,Integer> m:ht.entrySet())
        {  
            if(m.getKey().equals(strPalindromeMax))
                continue;
            char[] charArr = m.getKey().toCharArray();
            if(charArr[0]==charArr[1])
            {
                int value = m.getValue();
                if(value%2!=0)
                {
                    value--;
                }
                palindromeMax += value*2;
            }
            else{
                String reverse = charArr[1]+""+charArr[0];
                if(ht.containsKey(reverse))
                {
                    nonPalindromeMax += Math.min(ht.get(reverse),m.getValue())*2;
                }
            }
        }

        return nonPalindromeMax+palindromeMax+ht.getOrDefault(strPalindromeMax,0)*2;
    }
}