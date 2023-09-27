class Solution {
    public String decodeAtIndex(String s, int k) {
        long length = 0;
        int i = 0 ;
        while(length < k)
        {
            if(s.charAt(i) >= 97 && s.charAt(i) <= 122){
                length++;
            }
            else{
                length *= s.charAt(i)-'0';
            }
            i++;
        }

        for(int j = i-1; j >= 0 ; j--)
        {
            if(s.charAt(j) >=97 && s.charAt(j) <= 122)
            {
                if(k == 0 || k == length)
                {
                    return String.valueOf(s.charAt(j));
                }
                length--;
            }   
            else{
                length /= s.charAt(j)-'0';
                k %= length;
            }
        }

        return "";
    }
}