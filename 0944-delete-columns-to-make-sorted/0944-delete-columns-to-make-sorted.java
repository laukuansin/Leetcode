class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        int sizeStrs = strs.length;
        int sizeCharacter = strs[0].length();
        if(sizeStrs==1)
            return 0;
        
        for(int i=0;i<sizeCharacter;i++)
        {
            for(int j=1;j<sizeStrs;j++)
            {
                if(strs[j-1].charAt(i)-'a'>strs[j].charAt(i)-'a')
                {
                    res++;
                    break;
                }
            }
        }


        return res;
    }
}