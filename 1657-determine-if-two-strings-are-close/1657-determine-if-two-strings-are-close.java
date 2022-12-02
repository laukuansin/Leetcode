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
        for(int i=0;i<word1Arr.length;i++)
        {
            count1[word1Arr[i]-'a']++;
        }
        for(int i=0;i<word2Arr.length;i++)
        {
            count2[word2Arr[i]-'a']++;
        }

        for(int i=0;i<26;i++)
        {
            if(count1[i]==0&&count2[i]==0)
                continue;
            else if(count1[i]>0&&count2[i]>0)
                continue;
            else
                return false;
        }
        Arrays.sort(count1);
        Arrays.sort(count2);

        for(int i=0;i<26;i++)
        {
            if(count1[i]!=count2[i])
                return false;
        }
        return true;
    
    }
}