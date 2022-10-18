class Solution {
    public String countAndSay(int n) {
        return helper("1",1,n);
    }
    public String helper(String str,int cur, int n)
    {
        if(cur==n)
        {
            return str;
        }
        char[] charArr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int j=1;
        for(;j<charArr.length;j++)
        {
            if(charArr[j]==charArr[j-1])
            {
                count++;
            }
            else{
                sb.append(count);
                sb.append(charArr[j-1]);
                count=1;
            }
        }
        sb.append(count);
        sb.append(charArr[j-1]);
        return helper(sb.toString(),cur+1,n);
    }
}