class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return helper(s,wordDict,"",0,memo);
    }

    public boolean helper(String s,List<String> wordDict,String curStr, int index,Boolean[] memo)
    {
        if(index==s.length())
        {
            return curStr=="";
        }

        if(memo[index]!=null)
        {
            return memo[index];
        }

        for(int i = index ; i < s.length() ; i++)
        {
            curStr+=s.charAt(i);
            if(wordDict.contains(curStr))
            {
                if(helper(s,wordDict,"",i+1,memo))
                    return memo[index] = true;
            }
        }
       

        return memo[index] = false;
    }
}