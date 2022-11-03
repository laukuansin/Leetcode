import java.util.Hashtable;
class Solution {
    public int longestPalindrome(String[] words) {
        Hashtable<String,Integer> ht = new Hashtable<>();
        int palindromeMax = 0;
        int nonPalindromeMax = 0;
        boolean oddPalindromeCount = false;
        for(String word:words)
        {
            ht.put(word,ht.getOrDefault(word,0)+1);
        }
        
        for(Map.Entry<String,Integer> m:ht.entrySet())
        {  
            char[] charArr = m.getKey().toCharArray();
            if(charArr[0]==charArr[1])
            {
                if(m.getValue()%2==0)
                {
                    palindromeMax +=m.getValue()*2;
                }
                else{
                    palindromeMax += (m.getValue()-1)*2;
                    oddPalindromeCount = true;
                }
            }
            else{
                String reverse = charArr[1]+""+charArr[0];
                if(ht.containsKey(reverse))
                {
                    nonPalindromeMax += Math.min(ht.get(reverse),m.getValue())*2;
                }
            }
        }
            
        return oddPalindromeCount?nonPalindromeMax+palindromeMax+2:nonPalindromeMax+palindromeMax;
    }
}