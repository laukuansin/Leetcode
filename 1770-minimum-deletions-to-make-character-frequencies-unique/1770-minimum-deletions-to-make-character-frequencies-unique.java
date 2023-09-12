class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int ans = 0;
        for(char c : s.toCharArray())
        {
            count[c-'a']++;
        }

        for(int i = 0 ; i < 26 ; i++)
        {
            if(count[i]==0)
                continue;
            int frequency = count[i];
            int curFreq = frequency;
            while(hashMap.containsKey(curFreq))
            {
                curFreq--;
            }
            if(curFreq>0)
            {
                hashMap.put(curFreq,i);
            }
            ans+=(frequency-curFreq);
        }

        return ans;
    }
}