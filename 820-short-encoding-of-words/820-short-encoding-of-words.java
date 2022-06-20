class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> hSet = new HashSet<>(Arrays.asList(words));
        for(String word:words)
        {
            for(int i=1;i<word.length();i++)
            {
                hSet.remove(word.substring(i));
            }
        }
        
        int ans=0;
        
        for(String word:hSet)
        {
            ans+=word.length()+1;
        }
        return ans;
    }
}