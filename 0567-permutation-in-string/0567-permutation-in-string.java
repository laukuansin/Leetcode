class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //edge case: when s2 length more than s1
        if(s2.length()<s1.length())
            return false;

        //to store the frequency of each character
        int[] countChars = new int[26];
        //i: count starting index
        int i =0;
        for(;i<s1.length();i++)
        {
            countChars[s1.charAt(i)-'a']++;
            countChars[s2.charAt(i)-'a']--;
        }

        if(valid(countChars))
        {
            return true;
        }

        for(;i<s2.length();i++)
        {
            //add back the previous character frequency
            countChars[s2.charAt(i-s1.length())-'a']++;
            //minus the new one character frequency
            countChars[s2.charAt(i)-'a']--;
            //check again
            if (valid(countChars))
            {
                return true;
            }
        }
        return false;
    }

    //To check whether the current substring of s2 is permutation of s1 or not
    public boolean valid(int[] countChars)
    {
        for(int countChar:countChars)
        {
            if(countChar!=0)
            {
                return false;
            }
        }
        return true;
    }
}