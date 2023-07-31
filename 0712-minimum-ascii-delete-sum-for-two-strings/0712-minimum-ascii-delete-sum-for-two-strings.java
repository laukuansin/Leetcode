class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        return dfs(s1,s2,0,0,new Integer[s1.length()+1][s2.length()+1]);
    }

    public int dfs(String s1, String s2, int i, int j, Integer[][] memo)
    {
        if(memo[i][j]!=null)
        {
            return memo[i][j];
        }

        if(i==s1.length())
        {
            int sum = 0;
            for(int k = j ; k < s2.length() ; k++)
            {
                sum+=s2.charAt(k);
            }
            return sum;
        }

        if(j==s2.length())
        {
            int sum = 0;
            for(int k = i ; k < s1.length() ; k++)
            {
                sum+=s1.charAt(k);
            }
            return sum;
        }

        int nt = Math.min(s1.charAt(i)+dfs(s1,s2,i+1,j,memo),s2.charAt(j)+dfs(s1,s2,i,j+1,memo));
        int tk = Integer.MAX_VALUE;
        if(s1.charAt(i)==s2.charAt(j))
        {
            tk = dfs(s1,s2,i+1,j+1,memo);
        }

        return memo[i][j] = Math.min(nt,tk);

    }
}