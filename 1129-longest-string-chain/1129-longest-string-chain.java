class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)-> a.length()-b.length());
        HashMap<String,Integer> hashMap = new HashMap<>();
        int max = 1;

        for(int i = 0 ; i < words.length ; i++)
        {
           
            hashMap.put(words[i],1);
            for(int j = 0 ; j < words[i].length() ; j++)
            {
                String substring = words[i].substring(0,j)+words[i].substring(j+1);
                 
                if(hashMap.containsKey(substring))
                {
                    hashMap.put(words[i],Math.max(hashMap.get(words[i]),hashMap.get(substring)+1));
                }
            }
            max = Math.max(max,hashMap.get(words[i]));
        }
    
        return max;
    }
}