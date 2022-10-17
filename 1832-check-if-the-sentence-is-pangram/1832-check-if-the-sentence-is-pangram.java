class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] dp = new int[26];
        char[] charArr = sentence.toCharArray();
        
        for(int i=0;i<charArr.length;i++)
        {
            dp[charArr[i]-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(dp[i]<1)
                return false;
        }return true;
    }
}