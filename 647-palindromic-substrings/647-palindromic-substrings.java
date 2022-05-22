class Solution {
    
    int ans =0;
    char[] charArr;
    public int countSubstrings(String s) {
        charArr=s.toCharArray();
        for(int i=0;i<s.length();i++)
        {
            isPalindromic(s,i,i);
            isPalindromic(s,i,i+1);
        }
        return ans;
    }
    
    public void isPalindromic(String s, int start, int end)
    {
        while(start>=0&&end<s.length()&&charArr[start]==charArr[end])
        {
            ans++;
            start--;
            end++;
        }
    }
    
}