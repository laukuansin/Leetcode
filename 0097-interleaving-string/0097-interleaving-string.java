class Solution {
    int s1Length;
    int s2Length;
    int s3Length;
    char[] charArrS1;
    char[] charArrS2;
    char[] charArrS3;
    int[][] memo;
    boolean check = false;
    public boolean isInterleave(String s1, String s2, String s3) {
        s1Length = s1.length();
        s2Length = s2.length();
        s3Length = s3.length();
        memo = new int[s1Length][s2Length];
        for(int i=0;i<s1Length;i++)
        {
            for(int j=0;j<s2Length;j++)
            {
                memo[i][j]=-1;
            }
        }
        if(s1Length+s2Length!=s3Length)
        {
            return false;
        }
        charArrS1 = s1.toCharArray();
        charArrS2 = s2.toCharArray();
        charArrS3 = s3.toCharArray();
        helper(0,0,0);
        
        return check;
        
    }
    
    public void helper(int s1Idx,int s2Idx, int s3Idx)
    {
        if((s1Idx == s1Length)&&(s2Idx==s2Length)&&(s3Idx==s3Length))
        {
            check = true;
            return;
        }
        if(s1Idx<s1Length&&s2Idx<s2Length&&memo[s1Idx][s2Idx]==1)
            return;
        if(s1Idx<s1Length&&s2Idx<s2Length)
        {
            
            memo[s1Idx][s2Idx]=1;
        }
        if(s1Idx<s1Length&&charArrS3[s3Idx]==charArrS1[s1Idx])
        {
            helper(s1Idx+1,s2Idx,s3Idx+1);
        }
        if(s2Idx<s2Length&&charArrS3[s3Idx]==charArrS2[s2Idx])
        {
            helper(s1Idx,s2Idx+1,s3Idx+1);
        }
    
    }
}