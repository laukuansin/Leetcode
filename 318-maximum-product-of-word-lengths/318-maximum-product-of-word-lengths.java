class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        
        for(int i=0;i<words.length-1;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                if(check(words[i],words[j]))
                {
                    int currLength = words[i].length()*words[j].length();
                    max=Math.max(currLength,max);
                }
            }
        }
        return max;
    }
    
    private boolean check(String a, String b)
    {
        char[] charArr = a.toCharArray();
        
        for(char c : charArr)
        {
            if(b.indexOf(c)!=-1)
            {
                return false;
            }
        }
        return true;
    }
}