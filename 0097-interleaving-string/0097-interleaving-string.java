class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
        {
            return false;
        }
        if(s1.length()==0)
        {
            return s2.equals(s3);
        }
        if(s2.length()==0)
        {
            return s1.equals(s3);
        }

        return helper(s1,s2,s3,0,0,0,new Boolean[s1.length()+1][s2.length()+1]);
    }

    public boolean helper(String s1,String s2,String s3, int idx1,int idx2, int idx3,Boolean[][] memo)
    {
        if(idx3==s3.length())
        {
            return idx1==s1.length()&&idx2==s2.length();
        }

        if(memo[idx1][idx2]!=null)
        {
            return memo[idx1][idx2];
        }

        boolean selectS1 = false;
        boolean selectS2 = false;
        if(idx1<s1.length()&&s1.charAt(idx1)==s3.charAt(idx3))
        {
            selectS1 = helper(s1,s2,s3,idx1+1,idx2,idx3+1,memo); 
        }
        if(idx2<s2.length()&&s2.charAt(idx2)==s3.charAt(idx3))
        {
            selectS2 = helper(s1,s2,s3,idx1,idx2+1,idx3+1,memo);
        }
        if(idx1<s1.length()&&idx2<s2.length()&&s1.charAt(idx1)!=s3.charAt(idx3)&&s2.charAt(idx2)!=s3.charAt(idx3))
        {
            return false;
        }
        return memo[idx1][idx2]=selectS1||selectS2;
    }
}