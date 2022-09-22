class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = s.split(" ");
        for(String str:strArr)
        {
            sb.append(reverse(str)+" ");
        }
        sb.deleteCharAt(s.length());
        return sb.toString();
    }
    
    public String reverse(String s)
    {
        char[] charArr = s.toCharArray();
        int start=0;
        int end=charArr.length-1;
        while(start<end)
        {
            char tmp=charArr[start];
            charArr[start]=charArr[end];
            charArr[end]=tmp;
            start++;
            end--;
        }
        return new String(charArr);
    }
}