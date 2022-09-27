class Solution {
    public String pushDominoes(String dominoes) {
        if(dominoes.length()==1)
            return dominoes;
        int N = dominoes.length();
        int[] indexs = new int[N+2];
        char[] charD = new char[N+2];
        int idx = 1;
        indexs[0]=-1;
        charD[0]='L';
        
        for(int i=0;i<N;i++)
        {
            if(dominoes.charAt(i)!='.')
            {
                indexs[idx]=i;
                charD[idx++]=dominoes.charAt(i);
            }
        }
        indexs[idx]=N;
        charD[idx++]='R';
        
        char[] ans=dominoes.toCharArray();
        for(int i=0;i<idx-1;i++)
        {
            int x = indexs[i];
            int y=indexs[i+1];
            char c1 = charD[i];
            char c2=charD[i+1];
            if(c1==c2)
            {
               for(int j=x+1;j<y;j++)     
               {
                   ans[j]=c1;
               }
            }
            else if(c1>c2)
            {
                for(int j=x+1;j<y;j++)
                {
                    ans[j]=j-x==y-j?'.':j-x<y-j?'R':'L';
                }
            }
        }
        
        return String.valueOf(ans);
    }
}