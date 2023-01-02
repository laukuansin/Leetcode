class Solution {
    public boolean detectCapitalUse(String word) {
        boolean firstCap = true;
        boolean allCap = true;
        boolean allLow = true;
        char[] charArr = word.toCharArray();
        for(int i=0;i<charArr.length;i++)
        {
            char charWord = charArr[i];
            if(charWord>=65&&charWord<=90)
            {
                if(i>0)
                    firstCap = false;
                allLow = false;
            }
            else if(charWord>=97&&charWord<=122)
            {
                allCap = false;
                if(i==0)
                    firstCap = false;
            }
        }

        return allCap||allLow||firstCap;
    }
}