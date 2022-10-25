class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(res,new ArrayList<String>(),0,s);
        return res;
    }
    
    public void helper(List<List<String>> res, List<String> curList, int start, String s)
    {
        if(start>=s.length())
        {
            res.add(new ArrayList<String>(curList));
        }
        
        for(int end = start;end<s.length();end++)
        {
            if(isPalindrome(s,start,end))
            {
                curList.add(s.substring(start,end+1));
                helper(res,curList,end+1,s);
                curList.remove(curList.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String str, int start,int end)
    {
        char[] charArr = str.toCharArray();
        while(start<end)
        {
            if(charArr[start]!=charArr[end])
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}