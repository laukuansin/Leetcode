class Solution {
    public String breakPalindrome(String palindrome) {
        String res="";
        int size = palindrome.length();
        if(size<2)
            return "";
        
        char[] charArr = palindrome.toCharArray();
        if(size%2==0)
        {
            for(int i=0;i<size/2;i++)
            {
                if(charArr[i]!='a')
                {
                    charArr[i]='a';
                    return new String(charArr);
                }
            }
            charArr[size-1]='b';
            return new String(charArr);
        }
        else{
             for(int i=0;i<size/2;i++)
            {
                if(charArr[i]!='a')
                {
                    charArr[i]='a';
                    return new String(charArr);
                }
            }
            charArr[size-1]='b';
            return new String(charArr);
        }
    }
}