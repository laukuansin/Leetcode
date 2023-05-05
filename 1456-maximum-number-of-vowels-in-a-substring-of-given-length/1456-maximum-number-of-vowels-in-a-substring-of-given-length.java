class Solution {
    public int maxVowels(String s, int k) {
        int maximum = 0;
        int curMaximum = 0;
        
        for(int i=0;i<k;i++)
        {
            char c = s.charAt(i);
            if(isVowel(c))
            {
                maximum++;
                curMaximum++;
            }            
        }

        for(int i=k;i<s.length();i++)
        {
            char newC = s.charAt(i);
            char oldC = s.charAt(i-k);
            if(isVowel(newC))
            {
                curMaximum++;
            }
            if(isVowel(oldC))
            {
                curMaximum--;
            }
            maximum = Math.max(curMaximum,maximum);
        }


        return maximum;
    }

    public boolean isVowel(char c)
    {
        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
        {
            return true;
        }
        return false;
    }
}