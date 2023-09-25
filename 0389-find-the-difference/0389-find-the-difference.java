class Solution {
    public char findTheDifference(String s, String t)
    {
        char[] charArrS = s.toCharArray();
        char[] charArrT = t.toCharArray();
        Arrays.sort(charArrS);
        Arrays.sort(charArrT);
        int i = 0;
        for(; i < s.length() ; i++)
        {
            //System.out.println(charArr[]"");
            if(charArrS[i]!=charArrT[i])
            {
                return charArrT[i];
            }
        }

        return charArrT[i];
    }
    // public char findTheDifference(String s,String t)
    // {
    //     int result = 0;
    //     for(char charS : s.toCharArray())
    //     {
    //         result ^= charS;
    //     }

    //     for(char charT : t.toCharArray())
    //     {
    //         result ^= charT;
    //     }

    //     return (char)result;
    // }
    // Hash Table
    // public char findTheDifference(String s, String t) {
    //     if(s=="")
    //         return t.charAt(0);
    //     int[] count = new int[26];

    //     for(char charS : s.toCharArray())
    //     {
    //         count[charS-'a']--;
    //     }

    //     for(char charT : t.toCharArray())
    //     {
    //         count[charT-'a']++;

    //         if(count[charT-'a']==1)
    //         {
    //             return charT;
    //         }
    //     }

    //     return '\0';
    // }
}