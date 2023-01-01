class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] charArr = pattern.toCharArray();
        String[] sArr = s.split(" ");
        if(charArr.length!=sArr.length)
        {
            return false;
        }
        HashMap<Character,String> hm = new HashMap<>();
        for(int i=0;i<charArr.length;i++)
        {
            if(hm.containsKey(charArr[i]))
            {
                if(!hm.get(charArr[i]).equals(sArr[i]))
                    return false;
            }
            else{
                if(hm.containsValue(sArr[i]))
                    return false;
                hm.put(charArr[i],sArr[i]);
            }
        }
        return true;
    }
}