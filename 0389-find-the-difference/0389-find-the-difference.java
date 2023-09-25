class Solution {
    public char findTheDifference(String s, String t) {
        if(s=="")
            return t.charAt(0);
        int[] count = new int[26];

        for(char charS : s.toCharArray())
        {
            count[charS-'a']--;
        }

        for(char charT : t.toCharArray())
        {
            count[charT-'a']++;

            if(count[charT-'a']==1)
            {
                return charT;
            }
        }

        return '\0';
    }
}