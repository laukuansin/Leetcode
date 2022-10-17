class Solution {
    public boolean checkIfPangram(String sentence) {
        
        int seen=0;
        char[] charArr = sentence.toCharArray();
        for(int i=0;i<charArr.length;i++)
        {
            int num = charArr[i]-'a';
            int curBit  = 1<<num;
            
            seen|=curBit;
        }
        return seen==(1<<26)-1;
    }
}