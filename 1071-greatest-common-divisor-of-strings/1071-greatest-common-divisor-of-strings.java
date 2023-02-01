class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.equals(str2))
        {
            return str1;
        }
        //To ensure str1 is always longer
        boolean str1Longer = str1.length()>str2.length()?true:false;
        String ans = "";

        //swap str1 and str2
        if(!str1Longer) 
        {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }

        for(int i=1;i<=str2.length();i++)
        {
            String subStr = str2.substring(0,i);
            boolean checkForStr1 = checkStringContainsSubstr(str1,subStr,i);
            boolean checkForStr2 = checkStringContainsSubstr(str2,subStr,i);

            if(checkForStr1&&checkForStr2)
            {
                ans = subStr;
            }
        }

        return ans;
    }

    /*
    * This function is to check does the str contains one or more subStr
    */
    public boolean checkStringContainsSubstr(String str,String subStr,int subStrLength)
    {
        int startIdx = 0;
        while(startIdx+subStrLength<=str.length())
        {
            String subStrInStr = str.substring(startIdx,startIdx+subStrLength);
            if(!subStrInStr.equals(subStr))//if no contains sub str inside str
            {
                return false;
            }
            startIdx+=subStrLength;
        }
        //if str contains extra character
        //Example: str = ABC ABC D
        //         subStr = ABC
        if(startIdx!=str.length())
        {
            return false;
        }

        return true;
    }
}