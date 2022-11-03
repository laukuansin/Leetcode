import java.util.Hashtable;
class Solution {
    public int longestPalindrome(String[] words) {
        Hashtable<String,Integer> ht = new Hashtable<>();
        int palindromeMax = 0;
        int nonPalindromeMax = 0;
        String oddPalindromeMaxStr = "";
        int oddCountPalindromeMax = 0;
        
        for(String word:words)
        {
            ht.put(word,ht.getOrDefault(word,0)+1);
        }
        
        for(Map.Entry<String,Integer> m:ht.entrySet())
        {
            char[] charArr = m.getKey().toCharArray();
            if(charArr[0]==charArr[1])
            {
                if(ht.get(m.getKey())%2!=0&&ht.get(m.getKey())>oddCountPalindromeMax)
                {
                    oddCountPalindromeMax = ht.get(m.getKey())*2;
                    oddPalindromeMaxStr = m.getKey();
                }
            }
        }
        
        for(Map.Entry<String,Integer> m:ht.entrySet())
        {  
            if(m.getKey().equals(oddPalindromeMaxStr))
                continue;
            char[] charArr = m.getKey().toCharArray();
            if(charArr[0]==charArr[1])
            {
                palindromeMax += m.getValue()%2==0?m.getValue()*2:(m.getValue()-1)*2;
            }
            else{
                String reverse = charArr[1]+""+charArr[0];
                if(ht.containsKey(reverse))
                {
                    nonPalindromeMax += Math.min(ht.get(reverse),m.getValue())*2;
                }
            }
        }

        return nonPalindromeMax+palindromeMax+oddCountPalindromeMax;
    }
}