class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        int size = words.length;
        int[] bitMasks = new int[size];
        for(int i=0;i<size;i++)
        {
            int total =0;
            for(char c :words[i].toCharArray())
            {
                int num=(c-'a');
                int temp = 1;
                temp<<=num;
                total|=temp;

            }
            bitMasks[i]=total;
        }
        
        
        for(int i=0;i<words.length-1;i++)
        {
            for(int j=i+1;j<words.length;j++)
            {
                int conc=bitMasks[i]&bitMasks[j];
                if(conc==0)
                {
                    int currLength = words[i].length()*words[j].length();
                    max=Math.max(currLength,max);
                }
            }
        }
        return max;
    }
    
}